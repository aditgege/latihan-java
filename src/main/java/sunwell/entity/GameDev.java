package sunwell.entity;

import javax.persistence.*;
import java.util.List;

/**
 *
 */
@Entity
@Table(name="gamedev")
public class GameDev
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gamedev_id_seq")
    @SequenceGenerator(name = "gamedev_id_seq", sequenceName = "gamedev_id_seq", allocationSize = 1)
    private Integer id;

    @Column
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Game> listGame;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Game> getListGame() {
        return listGame;
    }

    public void setListGame(List<Game> listGame) {
        this.listGame = listGame;
    }
}
