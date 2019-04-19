package entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Log4j
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "projects")
public class Project extends EntityTable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "Project")
    private String project;
    @Column(name = "area")
    private String area;
    @Column(name = "cost")
    private Integer cost;

    @ManyToMany
    @JoinTable(name = "dev_project",
            joinColumns = @JoinColumn(name = "id_developer", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_project", referencedColumnName = "id")
    )
    private List<Developer> developers = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "company_project",
            joinColumns = @JoinColumn(name = "id_project", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_company", referencedColumnName = "id")
    )
    private List<Company> companies = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "customer_project",
            joinColumns = @JoinColumn(name = "id_project", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_customer", referencedColumnName = "id")
    )
    private List<Customer> customers = new ArrayList<>();
}
