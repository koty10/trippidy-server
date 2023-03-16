package cz.cvut.fel.trippidy.dto;

import cz.cvut.fel.trippidy.entity.Trip;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;

/**
 * A DTO for the {@link Trip} entity
 */
public class TripDto implements Serializable {
    private int id;
    private String name;
    private Collection<MemberDto> members;
    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;

    public TripDto(int id, String name, Collection<MemberDto> members, LocalDateTime dateFrom, LocalDateTime dateTo) {
        this.id = id;
        this.name = name;
        this.members = members;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public TripDto() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<MemberDto> getMembers() {
        return members;
    }

    public LocalDateTime getDateFrom() {
        return dateFrom;
    }

    public LocalDateTime getDateTo() {
        return dateTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripDto entity = (TripDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.members, entity.members) &&
                Objects.equals(this.dateFrom, entity.dateFrom) &&
                Objects.equals(this.dateTo, entity.dateTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, members, dateFrom, dateTo);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "members = " + members + ", " +
                "dateFrom = " + dateFrom + ", " +
                "dateTo = " + dateTo + ")";
    }
}