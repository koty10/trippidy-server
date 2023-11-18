package cz.cvut.fel.trippidy.dto;

import cz.cvut.fel.trippidy.entity.Trip;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;

/**
 * A DTO for the {@link Trip} entity
 */
public class TripDto implements Serializable {
    private String id;
    private String name;
    private Collection<MemberDto> members;
    //@JsonbDateFormat(value = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateFrom;
    //@JsonbDateFormat(value = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTo;
    private boolean isDeleted;
    private Collection<CompletedTransactionDto> completedTransactions;

    public TripDto(String id, String name, Collection<MemberDto> members, LocalDateTime dateFrom, LocalDateTime dateTo) {
        this.id = id;
        this.name = name;
        this.members = members;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public TripDto() {
    }

    @JsonbProperty("isDeleted")
    public boolean isDeleted() {
        return isDeleted;
    }

    @JsonbProperty("isDeleted")
    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getId() {
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

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMembers(Collection<MemberDto> members) {
        this.members = members;
    }

    public void setDateFrom(LocalDateTime dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(LocalDateTime dateTo) {
        this.dateTo = dateTo;
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

    public Collection<CompletedTransactionDto> getCompletedTransactions() {
        return completedTransactions;
    }

    public void setCompletedTransactions(Collection<CompletedTransactionDto> completedTransactions) {
        this.completedTransactions = completedTransactions;
    }
}
