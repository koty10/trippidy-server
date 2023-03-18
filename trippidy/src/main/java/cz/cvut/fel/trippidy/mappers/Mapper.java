package cz.cvut.fel.trippidy.mappers;

import cz.cvut.fel.trippidy.dto.*;
import cz.cvut.fel.trippidy.entity.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Collection;

@org.mapstruct.Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
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
        category.getItems().forEach(item -> item.setCategory(category));
    }

    ItemDto toDto(Item item);

    Item toEntity(ItemDto itemDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Item partialUpdate(ItemDto itemDto, @MappingTarget Item item);

    @Mappings({
            @Mapping(source = "userProfile.id", target = "userProfileId"),
            @Mapping(source = "userProfile.firstname", target = "userProfileFirstname"),
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
}