package cz.cvut.fel.trippidy.dto;

import cz.cvut.fel.trippidy.entity.CompletedTransaction;
import cz.cvut.fel.trippidy.serializers.BigDecimalDeserializer;
import cz.cvut.fel.trippidy.serializers.BigDecimalSerializer;

import javax.faces.convert.BigDecimalConverter;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTypeDeserializer;
import javax.json.bind.annotation.JsonbTypeSerializer;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * DTO for {@link CompletedTransaction}
 */
public class CompletedTransactionDto implements Serializable {
    private String id;
    private String payerId;
    private String payerUserProfileId;
    private String payerUserProfileFirstname;
    private String payerUserProfileLastname;
    private String payerUserProfileImage;
    private String payerUserProfileEmail;
    private String payeeId;
    private String payeeUserProfileId;
    private String payeeUserProfileFirstname;
    private String payeeUserProfileLastname;
    private String payeeUserProfileImage;
    private String payeeUserProfileEmail;
    private BigDecimal amount;
    private boolean canceled;
    private String tripId;

    public CompletedTransactionDto() {
    }

    public CompletedTransactionDto(String id, String payerId, String payerUserProfileId, String payerUserProfileFirstname, String payerUserProfileLastname, String payerUserProfileImage, String payeeId, String payeeUserProfileId, String payeeUserProfileFirstname, String payeeUserProfileLastname, String payeeUserProfileImage, BigDecimal amount, boolean canceled,
                                   String tripId, String payerUserProfileEmail, String payeeUserProfileEmail) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayerId() {
        return payerId;
    }

    public void setPayerId(String payerId) {
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

    public String getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(String payeeId) {
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

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
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