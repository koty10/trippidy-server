package cz.cvut.fel.trippidy.mappers;

import cz.cvut.fel.trippidy.dto.*;
import cz.cvut.fel.trippidy.entity.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Collection;

@org.mapstruct.Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {Mapper.class, Mapper.class})
public interface Mapper {
    Mapper MAPPER = Mappers.getMapper(Mapper.class);

    Trip toEntity(TripDto tripDto);

    TripDto toDto(Trip trip);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Trip partialUpdate(TripDto tripDto, @MappingTarget Trip trip);

    @AfterMapping
    default void linkMembers(@MappingTarget Trip trip) {
        trip.getMembers().forEach(member -> member.setTrip(trip));
    }

    UserProfile toEntity(UserProfileDto userProfileDto);

    UserProfileDto toDto(UserProfile userProfile);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserProfile partialUpdate(UserProfileDto userProfileDto, @MappingTarget UserProfile userProfile);

    Category toEntity(CategoryDto categoryDto);

    CategoryDto toDto(Category category);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Category partialUpdate(CategoryDto categoryDto, @MappingTarget Category category);

    @AfterMapping
    default void linkItems(@MappingTarget Category category) {
        if (category.getItems() == null) return;
        category.getItems().forEach(item -> item.setCategory(category));
    }

    @Mappings({
            @Mapping(source = "category.id", target = "categoryId"),
            @Mapping(source = "category.name", target = "categoryName"),
            @Mapping(source = "member.id", target = "memberId")
    })
    ItemDto toDto(Item item);

    @Mappings({
            @Mapping(source = "categoryId", target = "category.id"),
            @Mapping(source = "categoryName", target = "category.name"),
            @Mapping(source = "memberId", target = "member.id")
    })
    Item toEntity(ItemDto itemDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Item partialUpdate(ItemDto itemDto, @MappingTarget Item item);

    @Mappings({
            @Mapping(source = "userProfile.id", target = "userProfileId"),
            @Mapping(source = "userProfile.firstname", target = "userProfileFirstname"),
            @Mapping(source = "userProfile.lastname", target = "userProfileLastname"),
            @Mapping(source = "userProfile.image", target = "userProfileImage"),
            @Mapping(source = "trip.id", target = "tripId")
    })
    MemberDto toDto(Member member);

    @Mappings({
            @Mapping(source = "userProfileId", target = "userProfile.id"),
            @Mapping(source = "userProfileFirstname", target = "userProfile.firstname"),
            @Mapping(source = "userProfileLastname", target = "userProfile.lastname"),
            @Mapping(source = "userProfileImage", target = "userProfile.image"),
            @Mapping(source = "tripId", target = "trip.id")
    })
    Member toEntity(MemberDto memberDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Member partialUpdate(MemberDto memberDto, @MappingTarget Member member);


    Collection<TripDto> toDto(Collection<Trip> trip);

    Collection<Trip> toEntity(Collection<TripDto> tripDto);

    Collection<UserProfileDto> toDto1(Collection<UserProfile> userProfile);

    Collection<UserProfile> toEntity1(Collection<UserProfileDto> userProfileDto);

    Collection<MemberDto> toDto2(Collection<Member> member);

    Collection<Member> toEntity2(Collection<MemberDto> memberDto);

    Collection<ItemDto> toDto3(Collection<Item> item);

    Collection<Item> toEntity3(Collection<ItemDto> itemDto);

    Collection<CategoryDto> toDto4(Collection<Category> category);

    Collection<Category> toEntity4(Collection<CategoryDto> categoryDto);

    @Mapping(source = "itemId", target = "item.id")
    @Mapping(source = "payerId", target = "payer.id")
    FutureTransaction toEntity(FutureTransactionDto futureTransactionDto);

    @InheritInverseConfiguration(name = "toEntity")
    FutureTransactionDto toDto(FutureTransaction futureTransaction);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FutureTransaction partialUpdate(FutureTransactionDto futureTransactionDto, @MappingTarget FutureTransaction futureTransaction);

    @Mapping(source = "tripId", target = "trip.id")
    @Mapping(source = "payeeUserProfileImage", target = "payee.userProfile.image")
    @Mapping(source = "payeeUserProfileLastname", target = "payee.userProfile.lastname")
    @Mapping(source = "payeeUserProfileFirstname", target = "payee.userProfile.firstname")
    @Mapping(source = "payeeUserProfileId", target = "payee.userProfile.id")
    @Mapping(source = "payeeId", target = "payee.id")
    @Mapping(source = "payerUserProfileImage", target = "payer.userProfile.image")
    @Mapping(source = "payerUserProfileLastname", target = "payer.userProfile.lastname")
    @Mapping(source = "payerUserProfileFirstname", target = "payer.userProfile.firstname")
    @Mapping(source = "payerUserProfileId", target = "payer.userProfile.id")
    @Mapping(source = "payerId", target = "payer.id")
    CompletedTransaction toEntity(CompletedTransactionDto completedTransactionDto);

    @InheritInverseConfiguration(name = "toEntity")
    CompletedTransactionDto toDto(CompletedTransaction completedTransaction);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CompletedTransaction partialUpdate(CompletedTransactionDto completedTransactionDto, @MappingTarget CompletedTransaction completedTransaction);
}