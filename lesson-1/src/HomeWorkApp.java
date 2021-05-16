import java.util.ArrayList;

public class HomeWorkApp {

    public static void main(String[] args) {
        // инициализация участников
        var competitors = new ArrayList<IMovable>();
        competitors.add(new Human());
        competitors.add(new Cat());
        competitors.add(new Robot());

        // инициализация препятствий
        var obstacles = new IObstacle[10];
        for (var i = 0; i < 10; i+=2) {
            obstacles[i] = new Runway(((i / 2) + 1) * 1000);
            obstacles[i+1] = new Wall((i / 2) + 1);
        }

        for (IObstacle obstacle: obstacles) {
            if (obstacle instanceof Wall wall) {
                TryMove(wall, competitors);
            }
            else if (obstacle instanceof Runway runway) {
                TryMove(runway, competitors);
            }
            System.out.println("============================");
        }
    }

    private static void TryMove(Wall wall, ArrayList<IMovable> competitors) {
        for (var i = 0; i < competitors.size(); i++) {
            var competitor = competitors.get(i);
            if (!competitor.TryMove(wall)) {
                RemoveCompetitor(competitors, competitor);
                i--;
            }
        }
    }

    private static void TryMove(Runway runway, ArrayList<IMovable> competitors) {
        for (var i = 0; i < competitors.size(); i++) {
            var competitor = competitors.get(i);
            if (!competitor.TryMove(runway)) {
                RemoveCompetitor(competitors, competitor);
                i--;
            }
        }
    }

    private static void RemoveCompetitor(ArrayList<IMovable> competitors, IMovable competitor) {
        System.out.printf("%s покидает дистанцию%n", competitor.getName());
        competitors.remove(competitor);
    }
}

