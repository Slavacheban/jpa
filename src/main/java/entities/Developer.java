package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Log4j
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "developers")
public class Developer extends EntityTable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "City")
    private String city;
    @Column(name = "Age")
    private int age;
    @Column(name = "salary")
    private int salary;

    @ManyToMany
    @JoinTable(name = "developer_skills",
            joinColumns = @JoinColumn(name = "id_developer", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_skill", referencedColumnName = "id")
    )
    private Set<Skill> skills = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "developers")
    private Set<Project> projects = new HashSet<>();
}
