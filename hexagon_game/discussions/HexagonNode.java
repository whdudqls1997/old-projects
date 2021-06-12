/**------------------------------------------------------------------
* Description: A node class
*------------------------------------------------------------------*/

public class HexagonNode{

   // object on hexagon
   // public HexagonObject x; <- place holder for character object
   
   // adjacent hexagons
   public HexagonNode h1;
   public HexagonNode h2;
   public HexagonNode h3;
   public HexagonNode h4;
   public HexagonNode h5;
   public HexagonNode h6;
   
   // flags
   public boolean isOccupied;
   public boolean willOccupied;
   
   // closeness factor
   public int closeness;
   
   // type
   // public HexagonType type; <- place holder for hexagon type
   
   /**---------------------------------------------------------------
   * Description: A constructor
   * @param CharacterObject : Character information on hexagon
   * @param h1 : adjacent hexagon 1
   * @param h2 : adjacent hexagon 2
   * @param h3 : adjacent hexagon 3
   * @param h4 : adjacent hexagon 4 
   * @param h5 : adjacent hexagon 5
   * @param h6 : adjacent hexagon 6
   * @param isOccupied : tells if the hexagon is occupied
   * @param willOccupied : tells if the hexagon will be occupied
   * @param closeness : lower numbering close to the center
   *---------------------------------------------------------------*/
   public HexagonNode(/*HexagonObject x, */HexagonNode h1, HexagonNode h2, HexagonNode h3, HexagonNode h4, 
   HexagonNode h5, HexagonNode h6, boolean isOccupied, boolean willOccupied, int closeness /*, HexagonType type*/){
   
      /*this.x = x;*/
      this.h1 = h1;
      this.h2 = h2;
      this.h3 = h3;
      this.h4 = h4;
      this.h5 = h5;
      this.h6 = h6;
      this.isOccupied = isOccupied;
      this.willOccupied = willOccupied;
      this.closeness = closeness;
      /*this.type = type;*/
      
   }
   
   /**---------------------------------------------------------------
   * Description: Null constructor
   *---------------------------------------------------------------*/
   public QuestionNode(){
      this(null, null, null, null, null, null, null, null, null, null, null);
   }
}