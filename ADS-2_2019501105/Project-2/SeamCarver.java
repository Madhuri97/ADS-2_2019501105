import edu.princeton.cs.algs4.Picture;
import java.awt.Color;

public class SeamCarver {
	private Picture pic;
	private double energy[][];
	private int width;
	private int height;
	
	// create a seam carver object based on the given picture
   public SeamCarver(Picture picture) {
	   this.pic = new Picture(picture);
	   this.width = this.pic.width();
	   this.height = this.pic.height();
   }              
   
   // current picture
   public Picture picture() {
	   return this.pic;
   } 
   
   // width of current picture
   public int width() {
	   return width;
   } 
   
   // height of current picture
   public  int height() {
	   return height;
   }                          
   
   // energy of pixel at column x and row y
   public double energy(int x, int y) {
    if(x >= width() || x < 0 || y >= height() || y < 0) {
        throw new IndexOutOfBoundsException();
    }
    if(x == 0 || x == width() - 1 || y == 0 || y == height() - 1) {
        return 1000;
    }
    double dltX = 0.0;
    double dltY = 0.0;
    Color r1 = pic.get(x - 1, y);
    Color l1 = pic.get(x + 1, y);
    Color b1 = pic.get(x,y - 1);
    Color t1 = pic.get(x,y + 1);
    dltX = Math.pow((r1.getRed() - l1.getRed()), 2) + Math.pow((r1.getBlue() - l1.getBlue()), 2) + Math.pow((r1.getGreen() - l1.getGreen()), 2);
    dltY = Math.pow((b1.getRed() - t1.getRed()), 2) + Math.pow((b1.getBlue() - t1.getBlue()), 2) + Math.pow((b1.getGreen() - t1.getGreen()), 2);
    return Math.sqrt(dltX + dltY); 
}
   
   //transpose the energy array;
   private double[][] transpose() {
	   double [][] energyArr;
	   energyArr = new double[width][height];
	   
	   for (int j = 0; j < width; j++) { 
		   for (int i = 0; i < height; i++) {
			   energyArr[j][i] = energy(j, i);
//			   StdOut.print(energyArr[j][i]);
		   }
//		   StdOut.println();
	   }
	   return energyArr;
   }
   
 //store the energy in 2D array;
   private double[][] storeEnergy() {
	   double [][] energyArr;
	   energyArr = new double[height][width];
	   
	   for (int j = 0; j < height; j++) { 
		   for (int i = 0; i < width; i++) {
			   energyArr[j][i] = energy(i, j);
		   }
	   }
	   return energyArr;
   }
   
   private int[] verticalSeam(double[][] energy) {
	   int height1 = energy.length;
	   int width1 = energy[0].length;
//	   StdOut.println(height1 + " h, w: "+width1);
	   int[] path = new int[height1];

	   if(width1 != 1) {
		   
	   int [][] Pos = new int [height1][width1];

	   double [] rowEnergy = new double [width1];// an array to store total energy for one row.
	   double [] rowEnergy2 = new double [width1];
	   for(int k = 0; k < width1; k++) {
		   rowEnergy[k] = energy[0][k] + energy[1][k];
	   }
	   
	   double min;
	   int posi;
	   for(int row = 2; row < height1 - 1; row++) {
		   for(int col = 0; col < width1; col++) {
			   if (col == 0) {
				   min = (rowEnergy[0] < rowEnergy[1]) ? rowEnergy[0] : rowEnergy[1];
				   posi = (rowEnergy[0] < rowEnergy[1]) ? 0 : 1;
			   }

			   else {
				   min = (rowEnergy[col-1] < rowEnergy[col]) ? rowEnergy[col-1] : rowEnergy[col];
				   posi = (rowEnergy[col-1] < rowEnergy[col]) ? col-1 : col;
				   if (col != width1-1) {
					   min = (min < rowEnergy[col+1]) ? min : rowEnergy[col+1];
					   posi = (rowEnergy[posi] < rowEnergy[col+1]) ? posi : col+1;
				   }
			   }
			   Pos[row-2][col] = posi;
			   rowEnergy2[col] = energy[row][col] + min;
		   }
		   for (int enl = 0; enl < width1; enl++) {
			   rowEnergy[enl] = rowEnergy2[enl];
		   }
	   }
	   
	   int temPos = 0;
	   for (int p = 1; p < width1 - 1; p++) {
		   if(rowEnergy[p] < rowEnergy[temPos]) {
			   temPos = p;
		   }
	   }
	   
//	   double totalEnergy = rowEnergy[temPos] + energy[height-1][temPos];
//	   StdOut.println("total is: "+totalEnergy);
	   
//	   int[] path = new int[height1];
	   if (temPos > 0)
		   path[height1 - 1] = temPos - 1;
	   else 
		   path[height1 - 1] = temPos;
	   path[height1 - 2] = temPos;
	   for (int m = height1-3; m > 0; m--) {
		   path[m] = Pos[m - 1][path[m + 1]];
	   }
	   if (path[1] > 0)
		   path[0] = path[1] - 1;
	   else 
		   path[0] = path[1];
	   }
	   return path;
   }
   
   // sequence of indices for horizontal seam
   public   int[] findHorizontalSeam() {	
	   energy = transpose();
//	   StdOut.println(height+" hei, wid: "+width);
	   return verticalSeam(energy);
   }  
   
   // sequence of indices for vertical seam
   public   int[] findVerticalSeam() {
	   energy = storeEnergy();
//	   StdOut.println(height+" hei, wid: "+width);
	   return verticalSeam(energy);
   }              
   
   //check the validity of the seam array;
   private void checkSeam(int[] seam, int lenRange, int valRange) {
	   int len = seam.length;
	   if (seam.length != lenRange || lenRange <= 1)
		   throw new IllegalArgumentException();
	   for(int p = 0; p < len; p++) {
//		   StdOut.println(seam[p]+" mark");
		   if (seam[p] < 0 || seam[p] > valRange-1) {
			   throw new IllegalArgumentException();
		   }
		   if (p < len-1) {
			   if(Math.abs(seam[p] - seam[p + 1]) > 1) {
				   throw new IllegalArgumentException();
			   }
			}
	   }
   }
   
   // remove horizontal seam from current picture
   public    void removeHorizontalSeam(int[] seam) {//throws IllegalArgumentException{
	   if (this.height <= 0)
		   throw new IllegalArgumentException();
	   checkSeam(seam, width, height);

	   Picture newPic = new Picture(width, height-1);
	   Color color;
	   int row;
	   
       for (int j = 0; j < width; j++) {
           for (int i = 0; i < height; i++) {
               if (i == seam[j])
            	   continue;
               
        	   color = this.pic.get(j, i);
        	   row = i;
               if (i > seam[j])
            	   row--;
               
        	   newPic.set(j, row, color);
           }
       }
       this.pic = newPic;
       this.width = this.pic.width();
       this.height = this.pic.height();
   }   
   // remove vertical seam from current picture
   public    void removeVerticalSeam(int[] seam) {
	   if (this.width <= 1)
		   throw new IllegalArgumentException();
	   checkSeam(seam, height, width);
	   Picture newPic = new Picture(width - 1, height);
	   Color color;
	   int col;
       for (int j = 0; j < height; j++) {
           for (int i = 0; i < width; i++) {
               if (i == seam[j])
            	   continue;
        	   color = this.pic.get(i, j);
        	   col = i;
        	   if (i > seam[j])
        		   col--;
        	   
        	   newPic.set(col, j, color);
           }
       }
       this.pic = newPic;
       this.width = this.pic.width();
       this.height = this.pic.height();
   } 
}
