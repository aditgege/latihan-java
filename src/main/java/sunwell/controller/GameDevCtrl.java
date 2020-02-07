package sunwell.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sunwell.entity.Game;
import sunwell.entity.GameDev;
import sunwell.repository.GameDevRepository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
public class GameDevCtrl {

    @Autowired
    GameDevRepository repo;

    @GetMapping("/gamedevs")
    public Iterable<GameDev> getGameDev()
    {
        return repo.findAll();
    }

    @ResponseBody
    class tesdoang {
        String name;
        List<String> titles;

        public tesdoang() {}

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getTitles() {
            return titles;
        }

        public void setTitles(List<String> titles) {
            this.titles = titles;
        }
    }

    @GetMapping("/tesdoang")
    public tesdoang tes() {
        tesdoang t = new tesdoang();
        t.name = "Valve";

        List<String> titles = new ArrayList();
        titles.add("Counter Strike");
        titles.add("Dota2");
        t.titles = titles;

        return t;
    }

    @PostMapping("/gamedev")
    public GameDev create()
//    public GameDev create(@RequestParam(name="name") String devName,
//                          @RequestParam(name="title") List<String> listTitle)
    {
        System.out.println("START");

        GameDev dev = new GameDev();
        dev.setName("Blizzard");

        List<Game> listGame = new ArrayList(3);
        listGame.add(new Game("Overwatch", dev));
        listGame.add(new Game("Diablo", dev));
        listGame.add(new Game("Warcraft", dev));

//        Game g;
//        for (String s : data.titles) {
//            g = new Game();
//            g.setTitle(s);
//            g.setOwner(dev);
//
//            listGame.add(g);
//        }
        dev.setListGame(listGame);

        repo.save(dev);

        return dev;
    }

//    @PostMapping()
//    public GameDev createUsingObj(String devName, List<Game> listGames)
//    {
//    }
}
