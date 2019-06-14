package prims;
import java.util.*; 

public class Algorithm3 {
	// Vertices in graph
    private static int vert; 
    // Total Weight
    private static int tWeight;
    // Weighted adjacency matrix
    private static int[][] matrix;
    
    public static void main (String[] args) 
    { 
        matrix = enterMatrixData();
        printMatrix(matrix);
        System.out.println();
        pAlgo(matrix); 
        System.out.println("Total weight: " + tWeight);
    } 
    
    public static void printMatrix(int[][] matrix){
	    System.out.println("Your Matrix is: ");
	        
	        for (int i = 0; i < vert; i++)
	        {
	            for (int j = 0; j < vert; j++)
	            {
	                System.out.print(matrix[i][j]+"\t");
	            }
	            System.out.println();
	        }
	  }
    
    public static int minimumVal(int key[], Boolean set[]) 
    { 
        int min = Integer.MAX_VALUE, min_index=-1; 
  
        for (int v = 0; v < vert; v++) 
            if (set[v] == false && key[v] < min)
            {
                min = key[v];
                min_index = v;
            } 
        return min_index; 
    } 
    
    public static int[] getAdjV(int[][] matrix, int vert) {
	      int[] adjV = new int[vert-1];
	      int c = 0;
		  for (int j = 0; j < vert; j++) {
	            	if(matrix[vert][j] == 1) {
	            		int e = j;
	            		for(int i = 0; i < vert; i++) {
	            			if(matrix[i][e] == 1 && i != vert) {
	            				adjV[c++] = i;
	            			}
	            		}
	            	}
	        }
	      	return adjV;
	  }
   
    public static int degree(int[][] matrix, int v) {
		  int count = 0;
		  for(int j = 0; j < v; j++) {
			  if(matrix[v][j] != 0) {
				  count++;
			  }
		  }
		  return count;
	  }
    
    public static int getWeight() 
    {
    	return tWeight;
    }
    
    public static void printPrimAlgo(int pWeight[], int n, int matrix[][]) 
    { 
        System.out.println("Edge"); 
        for (int i = 1; i < vert; i++)
        {
            System.out.println(pWeight[i]+" - "+ i); 
            tWeight += matrix[i][pWeight[i]];
        }
    } 
    
    public static int[][] enterMatrixData(){
    	Scanner scan = new Scanner(System.in);
        System.out.println("Enter The Number vertices ");
        vert = scan.nextInt();
        
        //defining 2D array to hold matrix data
        matrix = new int[vert][vert];
	  
	          for (int i = 0; i < vert; i++)
	          {
	        	  System.out.println("Enter adjacency matrix "
	        	  		+ "data for vertex (row) " + (i + 1));
	              for (int j = 0; j < vert; j++)
	              {
	            	  System.out.println("and vertex (column) "
	              + (j + 1) +":");
	                  matrix[i][j] = scan.nextInt();
	              }
	          }
	          scan.close();
	          return matrix;
	  }
    
    public static void alterMatrix(int[][] matrix) {
    	enterMatrixData();
    }
    
    public static void pAlgo(int matrix[][]) 
    { 
        int pWeight[] = new int[vert]; 
        int key[] = new int [vert]; 
        Boolean mstSet[] = new Boolean[vert]; 
        for (int i = 0; i < vert; i++) 
        { 
            key[i] = Integer.MAX_VALUE; 
            mstSet[i] = false; 
        } 
        key[0] = 0;     
        pWeight[0] = -1; 
        for (int count = 0; count < vert-1; count++) 
        {
            int u = minimumVal(key, mstSet); 
            mstSet[u] = true; 
            for (int v = 0; v < vert; v++) 
                if (matrix[u][v]!=0 && mstSet[v] == false && 
                    matrix[u][v] < key[v]) 
                { 
                    pWeight[v] = u; 
                    key[v] = matrix[u][v]; 
                } 
        } 
        printPrimAlgo(pWeight, vert, matrix); 
    } 
    
    private static int[][] adjToInc(int[][] matrix, int vert){
		  int[][] adj = new int[vert][vert];
		  for(int a = 0; a < vert; a++) {
			  for(int b = 0; b < vert; b++) {
				  adj[a][b] = 0;
			  }
		  }
		  int v1;
		  int e;
		  for(int i = 0; i < vert; i++) {
			  for(int j = 0; j < vert; j++) {
				  if(matrix[i][j] == 1) {
					  v1 = i;
					  e = j;
					  for(int x = 0; x < vert; x++) {
						  if(matrix[x][e] == 
						1 && v1 != x) {
						adj[v1][x] = 1;
						  }
					  }
				  }
			  }
		  }
		  printMatrix(matrix);
		  return adj;
	  }
    
    public static void emptyMatrix() 
    {
    	matrix = new int[vert][vert];
    }
    
    public static void alterVerticies()
    {
    	Scanner scan = new Scanner(System.in);
        System.out.println("Enter The Number vertitices ");
        vert = scan.nextInt();
        scan.close();
        
        alterMatrix(matrix);
    }
    
    public static int getVert() 
    {
    	return vert;
    }
    
    public static int[][] getMatrix()
    {
    	return matrix;
    }
}
