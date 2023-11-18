package cz.cvut.fel.trippidy.dto;

import cz.cvut.fel.trippidy.entity.CompletedTransaction;
import cz.cvut.fel.trippidy.serializers.BigDecimalDeserializer;
import cz.cvut.fel.trippidy.serializers.BigDecimalSerializer;

import jakarta.faces.convert.BigDecimalConverter;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTypeDeserializer;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

/**
 * DTO for {@link CompletedTransaction}
 */
public class CompletedTransactionDto implements Serializable {
    private UUID id;
    private UUID payerId;
    private String payerUserProfileId;
    private String payerUserProfileFirstname;
    private String payerUserProfileLastname;
    private String payerUserProfileImage;
    private String payerUserProfileEmail;
    private UUID payeeId;
    private String payeeUserProfileId;
    private String payeeUserProfileFirstname;
    private String payeeUserProfileLastname;
    private String payeeUserProfileImage;
    private String payeeUserProfileEmail;
    private BigDecimal amount;
    private boolean canceled;
    private UUID tripId;

    public CompletedTransactionDto() {
    }

    public CompletedTransactionDto(UUID id, UUID payerId, String payerUserProfileId, String payerUserProfileFirstname, String payerUserProfileLastname, String payerUserProfileImage, UUID payeeId, String payeeUserProfileId, String payeeUserProfileFirstname, String payeeUserProfileLastname, String payeeUserProfileImage, BigDecimal amount, boolean canceled,
                                   UUID tripId, String payerUserProfileEmail, String payeeUserProfileEmail) {
        this.id = id;
        this.payerId = payerId;
        this.payerUserProfileId = payerUserProfileId;
        this.payerUserProfileFirstname = payerUserProfileFirstname;
        this.payerUserProfileLastname = payerUserProfileLastname;
        this.payerUserProfileImage = payerUserProfileImage;
        this.payerUserProfileEmail = payerUserProfileEmail;
        this.payeeId = payeeId;
        this.payeeUserProfileId = payeeUserProfileId;
        this.payeeUserProfileFirstname = payeeUserProfileFirstname;
        this.payeeUserProfileLastname = payeeUserProfileLastname;
        this.payeeUserProfileImage = payeeUserProfileImage;
        this.payeeUserProfileEmail = payeeUserProfileEmail;
        this.amount = amount;
        this.canceled = canceled;
        this.tripId = tripId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPayerId() {
        return payerId;
    }

    public void setPayerId(UUID payerId) {
        this.payerId = payerId;
    }

    public String getPayerUserProfileId() {
        return payerUserProfileId;
    }

    public void setPayerUserProfileId(String payerUserProfileId) {
        this.payerUserProfileId = payerUserProfileId;
    }

    public String getPayerUserProfileFirstname() {
        return payerUserProfileFirstname;
    }

    public void setPayerUserProfileFirstname(String payerUserProfileFirstname) {
        this.payerUserProfileFirstname = payerUserProfileFirstname;
    }

    public String getPayerUserProfileLastname() {
        return payerUserProfileLastname;
    }

    public void setPayerUserProfileLastname(String payerUserProfileLastname) {
        this.payerUserProfileLastname = payerUserProfileLastname;
    }

    public String getPayerUserProfileImage() {
        return payerUserProfileImage;
    }

    public void setPayerUserProfileImage(String payerUserProfileImage) {
        this.payerUserProfileImage = payerUserProfileImage;
    }

    public UUID getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(UUID payeeId) {
        this.payeeId = payeeId;
    }

    public String getPayeeUserProfileId() {
        return payeeUserProfileId;
    }

    public void setPayeeUserProfileId(String payeeUserProfileId) {
        this.payeeUserProfileId = payeeUserProfileId;
    }

    public String getPayeeUserProfileFirstname() {
        return payeeUserProfileFirstname;
    }

    public void setPayeeUserProfileFirstname(String payeeUserProfileFirstname) {
        this.payeeUserProfileFirstname = payeeUserProfileFirstname;
    }

    public String getPayeeUserProfileLastname() {
        return payeeUserProfileLastname;
    }

    public void setPayeeUserProfileLastname(String payeeUserProfileLastname) {
        this.payeeUserProfileLastname = payeeUserProfileLastname;
    }

    public String getPayeeUserProfileImage() {
        return payeeUserProfileImage;
    }

    public void setPayeeUserProfileImage(String payeeUserProfileImage) {
        this.payeeUserProfileImage = payeeUserProfileImage;
    }

    @JsonbTypeDeserializer(BigDecimalDeserializer.class)
    @JsonbTypeSerializer(BigDecimalSerializer.class)
    public BigDecimal getAmount() {
        return amount;
    }

    @JsonbTypeDeserializer(BigDecimalDeserializer.class)
    @JsonbTypeSerializer(BigDecimalSerializer.class)
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @JsonbProperty("isCanceled")
    public boolean isCanceled() {
        return canceled;
    }

    @JsonbProperty("isCanceled")
    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompletedTransactionDto entity = (CompletedTransactionDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.payerId, entity.payerId) &&
                Objects.equals(this.payerUserProfileId, entity.payerUserProfileId) &&
                Objects.equals(this.payerUserProfileFirstname, entity.payerUserProfileFirstname) &&
                Objects.equals(this.payerUserProfileLastname, entity.payerUserProfileLastname) &&
                Objects.equals(this.payerUserProfileImage, entity.payerUserProfileImage) &&
                Objects.equals(this.payerUserProfileEmail, entity.payerUserProfileEmail) &&
                Objects.equals(this.payeeId, entity.payeeId) &&
                Objects.equals(this.payeeUserProfileId, entity.payeeUserProfileId) &&
                Objects.equals(this.payeeUserProfileFirstname, entity.payeeUserProfileFirstname) &&
                Objects.equals(this.payeeUserProfileLastname, entity.payeeUserProfileLastname) &&
                Objects.equals(this.payeeUserProfileImage, entity.payeeUserProfileImage) &&
                Objects.equals(this.payeeUserProfileEmail, entity.payeeUserProfileEmail) &&
                Objects.equals(this.amount, entity.amount) &&
                Objects.equals(this.canceled, entity.canceled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, payerId, payerUserProfileId, payerUserProfileFirstname, payerUserProfileLastname, payerUserProfileImage, payerUserProfileEmail, payeeId, payeeUserProfileId, payeeUserProfileFirstname, payeeUserProfileLastname, payeeUserProfileImage, payeeUserProfileEmail, amount, canceled);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "payerId = " + payerId + ", " +
                "payerUserProfileId = " + payerUserProfileId + ", " +
                "payerUserProfileFirstname = " + payerUserProfileFirstname + ", " +
                "payerUserProfileLastname = " + payerUserProfileLastname + ", " +
                "payerUserProfileImage = " + payerUserProfileImage + ", " +
                "payerUserProfileEmail = " + payerUserProfileEmail + ", " +
                "payeeId = " + payeeId + ", " +
                "payeeUserProfileId = " + payeeUserProfileId + ", " +
                "payeeUserProfileFirstname = " + payeeUserProfileFirstname + ", " +
                "payeeUserProfileLastname = " + payeeUserProfileLastname + ", " +
                "payeeUserProfileImage = " + payeeUserProfileImage + ", " +
                "payeeUserProfileEmail = " + payeeUserProfileEmail + ", " +
                "amount = " + amount + ", " +
                "canceled = " + canceled + ")";
    }

    public UUID getTripId() {
        return tripId;
    }

    public void setTripId(UUID tripId) {
        this.tripId = tripId;
    }

    public String getPayerUserProfileEmail() {
        return payerUserProfileEmail;
    }

    public String getPayeeUserProfileEmail() {
        return payeeUserProfileEmail;
    }

    public void setPayerUserProfileEmail(String payerUserProfileEmail) {
        this.payerUserProfileEmail = payerUserProfileEmail;
    }

    public void setPayeeUserProfileEmail(String payeeUserProfileEmail) {
        this.payeeUserProfileEmail = payeeUserProfileEmail;
    }
}
