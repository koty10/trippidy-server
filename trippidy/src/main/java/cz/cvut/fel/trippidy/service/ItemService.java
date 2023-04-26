package cz.cvut.fel.trippidy.service;

import cz.cvut.fel.trippidy.dto.ItemDto;
import cz.cvut.fel.trippidy.dto.TripDto;
import cz.cvut.fel.trippidy.entity.*;
import cz.cvut.fel.trippidy.mappers.Mapper;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.auth.message.AuthException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

//@ApplicationScoped
@Stateless
public class ItemService {

    @PersistenceContext
    EntityManager entityManager;

    public ItemDto updateItem(String userId, ItemDto itemDto) throws AuthException {
        var item = entityManager.find(Item.class, itemDto.getId());
        if (!item.getMember().getUserProfile().getId().equals(userId)) throw new AuthException("User not authorized to edit this item.");

        item.setAmount(itemDto.getAmount());
        item.setCategory(item.getCategory());
        item.setPrice(itemDto.getPrice());
        item.setName(itemDto.getName());
        item.setChecked(itemDto.isChecked());
        item.setPrivate(item.isPrivate());
        item.setShared(item.isShared());

        var category = item.getCategory();
        category.setName(itemDto.getCategoryName());

        entityManager.persist(item);
        entityManager.persist(category);
        return Mapper.MAPPER.toDto(item);
    }

    public ItemDto createItem(String userId, ItemDto itemDto) throws Exception { //todo remove userId
        if (entityManager.find(Item.class, itemDto.getId()) != null) throw new Exception("Element already exists");

        Item item = Mapper.MAPPER.toEntity(itemDto);
        var category = entityManager.createNamedQuery(Category.FIND_BY_NAME, Category.class)
                .setParameter("name", item.getCategory().getName())
                .getResultStream()
                .findFirst();
        if (category.isPresent()) {
            item.setCategory(category.get());
        } else {
            entityManager.persist(item.getCategory());
        }

        entityManager.persist(item);
        var member = entityManager.find(Member.class, item.getMember().getId());
        member.getItems().add(item);
        entityManager.persist(member);
        return Mapper.MAPPER.toDto(item);
    }
}
