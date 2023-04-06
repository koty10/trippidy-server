package cz.cvut.fel.trippidy.service;

import cz.cvut.fel.trippidy.dto.ItemDto;
import cz.cvut.fel.trippidy.dto.TripDto;
import cz.cvut.fel.trippidy.entity.Item;
import cz.cvut.fel.trippidy.entity.Member;
import cz.cvut.fel.trippidy.entity.Trip;
import cz.cvut.fel.trippidy.entity.UserProfile;
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
        item.setChecked(itemDto.getIsChecked());
        item.setPrivate(item.isPrivate());
        item.setShared(item.getIsShared());

        entityManager.persist(item);
        return Mapper.MAPPER.toDto(item);
    }
}
