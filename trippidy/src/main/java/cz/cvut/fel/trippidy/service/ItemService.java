package cz.cvut.fel.trippidy.service;

import cz.cvut.fel.trippidy.dto.ItemDto;
import cz.cvut.fel.trippidy.dto.TripDto;
import cz.cvut.fel.trippidy.entity.*;
import cz.cvut.fel.trippidy.mappers.Mapper;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.security.auth.message.AuthException;
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

        var updatedItem = Mapper.MAPPER.toEntity(itemDto);

//        item.setAmount(itemDto.getAmount());
//        item.setCategory(itemDto.getca);
//        item.setPrice(itemDto.getPrice());
//        item.setName(itemDto.getName());
//        item.setChecked(itemDto.isChecked());
//        item.setPrivate(itemDto.isPrivate());
//        item.setShared(itemDto.isShared());
//        item.setFutureTransactions(itemDto.getFutureTransactions());

//        var category = item.getCategory();
//        category.setName(itemDto.getCategoryName());

        // Handle deletions
        for (FutureTransaction oldItem : item.getFutureTransactions()) {
            if (!updatedItem.getFutureTransactions().contains(oldItem)) {
                FutureTransaction itemToDelete = entityManager.merge(oldItem); // reattach
                entityManager.remove(itemToDelete); // and remove
            }
        }

        entityManager.merge(updatedItem);
//        entityManager.persist(item);
//        entityManager.persist(category);


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
