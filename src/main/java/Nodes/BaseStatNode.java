package Nodes;

/**
 * Created by ssdmitriev on 29.03.16.
 */
public abstract class BaseStatNode {
    Position position;

    public class Position {
        private int line;
        private int symbol;

        public Position(int line, int symbol) {
            this.line = line;
            this.symbol = symbol;
        }

        public String toString() {
            return line + ":" + symbol;
        }
    }

    public BaseStatNode() {
        position = null;
    }

    public void setPosition(int line, int symbol) {
        position = new Position(line, symbol);
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

//    public abstract <T> T accept(AstVisitor<T> v);
}
