package com.example.sdaApplication.mapper.organization;

import com.example.sdaApplication.model.ConferenceRoom;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "organization_dto")
public class OrganizationDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false)
    @Size(min = 2, max = 20, message = "Invalid first name!(2-20 characters)")
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "identifier", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<ConferenceRoom> conferenceRooms;
}
