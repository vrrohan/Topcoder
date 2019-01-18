/*
Original Problem statement link - https://community.topcoder.com/stat?c=problem_statement&pm=14612
Problem Statement
        
You have a rectangular bitmap that consists of n rows by m columns of pixels. You are given the bitmap encoded as a String[] image. 
Each pixel of the bitmap is either black or white. Black pixels are represented by the character '0', white ones by '1'.

You are also given an int k that divides both n and m. You want to check whether you can compress the bitmap by shrinking it k times in each dimension. 
More precisely, the compression works as follows:

Divide the bitmap into blocks of size k times k pixels.
Check whether each block consists of pixels of a single color only. If some block contains both black and white pixels, the bitmap cannot be compressed.
Compress the bitmap by shrinking each block into a single pixel of the respective color.
Determine whether we can compress the given bitmap for the given k. If we can, return "Possible", otherwise, return "Impossible". Note that the return value is case-sensitive.
 
Definition        
Class:  ImageCompression
Method: isPossible
Parameters: String[], int
Returns:    String
Method signature:   String isPossible(String[] image, int k)
(be sure your method is public)
    
Constraints
-   n,m will be between 2 and 50, inclusive.
-   image will contain exactly n elements.
-   Each element of image will contain exactly m characters.
-   Each character of each element of image will be '0' or '1'.
-   k will be between 2 and 50.
-   k will divide n and m.
 
Examples
0)  {"0011","0011","1100","1100","0000","0000"}
2
Returns: "Possible"

1)  {"0011","0011","1100","1100","0010","0000"}
2
Returns: "Impossible"
The block in the bottom right corner contains three black pixels and one white pixel.

2)  {"111000111","111000111","111000111"}
3
Returns: "Possible"

3)  {"001100","001100","110011","110011","001100","001100"}
6
Returns: "Impossible"
This is not compressible when k=6.

4)  {"001100","001100","110011","110011","001100","001100"}
2
Returns: "Possible"
It is compressible when k=2 however.

5)  {"11111111","11111111","11111111","11111111",
"11111111","11111111","11111111","11111111"}
4
Returns: "Possible"
*/

public class ImageCompression {
    static String isPossible(String[] img, int k) {
        String imgCompress = "Possible";
        if(img.length%k!=0) {   imgCompress="Impossible";   }
        if(img.length<k) { imgCompress="Impossible";   }
        if((img.length%k==0)&(img.length>=k)) {
            //for loop 1
            for(int i=0; i<img.length; i++) {
                String s = img[i];
                int j=k;
                boolean b = true;
                //for loop 2
                for(int x=0; x<s.length(); x+=j, j+=k) {
                    String c = s.substring(x,j);
                    char ch = c.charAt(0);
                    //for loop 3
                    for(int z=0; z<c.length(); z++) {
                        if(c.charAt(z)!=ch) {
                            imgCompress="Impossible";
                            b=false;
                            break;
                        }
                    }//end of for loop 3
                    if(!b) { break; } //to break from outer for loop    
                }//end of for loop 2
                if(!b) {break;}
            }//end of for loop 1        
        }//if ends...
        return imgCompress;
    }

    public static void main(String[] args) {
        String[] str = {"0011","0011","1100","1100","0000","0000"};
        String[] str2 = {"0011","0011","1100","1100","0010","0000"};
        String[] str3 = {"111000111","111000111","111000111"};
        String[] str4 = {"001100","001100","110011","110011","001100","001100"};
        String[] str5 = {"001100","001100","110011","110011","001100","001100"};
        String[] str6 = {"11111111","11111111","11111111","11111111","11111111","11111111","11111111","11111111"};

        System.out.println(isPossible(str,2));
        System.out.println(isPossible(str2,2));
        System.out.println(isPossible(str3,3));    
        System.out.println(isPossible(str4,6));
        System.out.println(isPossible(str5,2));
        System.out.println(isPossible(str6,4));
    }
}
