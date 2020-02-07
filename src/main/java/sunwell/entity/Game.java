package sunwell.entity;

import javax.persistence.*;

@Entity
@Table(name="game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_id_seq")
    @SequenceGenerator(name = "game_id_seq", sequenceName = "game_id_seq", allocationSize = 1)
    private int id;

    @Column
    private String title;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private GameDev owner;

    public Game() {}

    public Game(String title, GameDev owner)
    {
        this.title = title;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GameDev getOwner() {
        return owner;
    }

    public void setOwner(GameDev owner) {
        this.owner = owner;
    }
}
