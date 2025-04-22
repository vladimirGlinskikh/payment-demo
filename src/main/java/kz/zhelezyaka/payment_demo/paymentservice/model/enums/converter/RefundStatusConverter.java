package kz.zhelezyaka.payment_demo.paymentservice.model.enums.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import kz.zhelezyaka.payment_demo.paymentservice.model.enums.RefundStatus;

@Converter(autoApply = true)
public class RefundStatusConverter implements AttributeConverter<RefundStatus, String> {
    @Override
    public String convertToDatabaseColumn(RefundStatus attribute) {
        return attribute == null ? null : attribute.name();
    }

    @Override
    public RefundStatus convertToEntityAttribute(String dbDate) {
        return dbDate == null ? null : RefundStatus.fromString(dbDate);
    }
}
