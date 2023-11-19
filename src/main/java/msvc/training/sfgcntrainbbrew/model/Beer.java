package msvc.training.sfgcntrainbbrew.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import msvc.training.sfgcntrainbbrew.helpers.json.CustomSerializer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Beer {

    @JsonProperty("beerId")
    @Null
    private UUID id;

    @NotBlank
    private String beerName;

    @NotBlank
    private String beerStyle;

    @Positive
    private Long upc;

    @Positive
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal price;

    //@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss,nnnnnnnnnZ")
    @JsonProperty("createdDate")
    @JsonSerialize(using = CustomSerializer.class)

    private OffsetDateTime createdDate;

    //@JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING )
    @JsonProperty("lastUpdatedDate")
    @JsonSerialize(using = CustomSerializer.class)
    private OffsetDateTime lastUpdatedDate;



}
