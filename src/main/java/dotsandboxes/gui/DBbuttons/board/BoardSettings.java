package dotsandboxes.gui.DBbuttons.board;

import java.awt.*;

public class BoardSettings {

    enum ElementType{HORIZONTAL_LINE,VERTICAL_LINE,BOX,DOT}

    //queste sono alla fine final? (insopportabile gioco di parole)
    private final Integer ROWS;
    private final Integer COLUMNS;

    private BoardButtonSpecifics horizontalGridSpec;
    private BoardButtonSpecifics verticalGridSpec;
    private BoardButtonSpecifics boxesGridSpec;
    private BoardButtonSpecifics dotsGridSpec;

    private Integer xOffset;
    private Integer yOffset;
    private final Integer DIM_ONE=45;
    private final Integer DIM_TWO=15;
    private final Integer HINTS=50;


    public BoardSettings(Integer rows, Integer cols){


        //è da capire bene come mettere questi numeri sotto forma di costanti
        ROWS=rows;
        COLUMNS=cols;
        xOffset=120+(340-(DIM_ONE+DIM_TWO)*cols)/2;
        yOffset=50+(300-(DIM_ONE+DIM_TWO)*rows)/2;


        horizontalGridSpec = new BoardButtonSpecifics(ElementType.HORIZONTAL_LINE,rows+1, cols, new Rectangle(DIM_ONE, DIM_TWO), new Point(xOffset+DIM_TWO, yOffset), DIM_ONE+DIM_TWO,HINTS);
        verticalGridSpec = new BoardButtonSpecifics(ElementType.VERTICAL_LINE,rows, cols+1, new Rectangle(DIM_TWO, DIM_ONE),new Point( xOffset, yOffset+DIM_TWO), DIM_ONE+DIM_TWO,HINTS);
        dotsGridSpec = new BoardButtonSpecifics(ElementType.DOT,rows+1, cols+1,new Rectangle( DIM_TWO, DIM_TWO),new Point( xOffset, yOffset), DIM_ONE+DIM_TWO,HINTS);
        boxesGridSpec =new BoardButtonSpecifics(ElementType.BOX,rows,cols,new Rectangle(DIM_ONE,DIM_ONE),new Point(xOffset+DIM_TWO,yOffset+DIM_TWO),DIM_ONE+DIM_TWO,HINTS);
    }

    public Integer getColumns() {return COLUMNS;}
    public Integer getRows() { return ROWS; }
    public Integer getXOffset(){return  xOffset;}
    public Integer getYOffset(){return  yOffset;}
    public Integer getDimOne() {return  DIM_ONE;}
    public Integer getDimTwo() {return  DIM_TWO;}
    public Integer getHints() {return HINTS;}

    public BoardButtonSpecifics getHorizontalGridSpec() {return horizontalGridSpec; }
    public BoardButtonSpecifics getVerticalGridSpec() {return verticalGridSpec; }
    public BoardButtonSpecifics getBoxesGridSpec() {return boxesGridSpec; }
    public BoardButtonSpecifics getDotsGridSpec() {return dotsGridSpec;}

}

