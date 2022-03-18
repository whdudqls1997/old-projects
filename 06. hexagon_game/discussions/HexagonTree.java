/**------------------------------------------------------------------
* Description: Creates the tree
*------------------------------------------------------------------*/

public class HexagonTree{

   HexagonNode overallRoot; //Root where nodes will stack onto
   
   /**---------------------------------------------------------------
   * Description: void constructor
   *---------------------------------------------------------------*/
   public HexagonTree(){
      //Initializing class variables
      overallRoot = new HexagonNode(/*object*/ null, null, null, null, null, null, false, false, 1, /*type*/);
   }
   
   public void createTree(HexagonNode next){
   
      if(){
         return;
      }
      
      overallRoot.seth1(new HexagonNode(/*object*/ createTree(), null, null, null, null, null, false, false, 1, /*type*/));
      overallRoot.seth2();
      overallRoot.seth3();
      overallRoot.seth4();
      overallRoot.seth5();
      overallRoot.seth6();
   
   }
}