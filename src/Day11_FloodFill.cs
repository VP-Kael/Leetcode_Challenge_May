/*
 * An image is represented by a 2-D array of integers,
 * each integer representing the pixel value of the image (from 0 to 65535).
 * 
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill,
 * and a pixel value newColor, "flood fill" the image.
 *
 * To perform a "flood fill", consider the starting pixel,
 * plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
 * plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on.
 * Replace the color of all of the aforementioned pixels with the newColor.
 *
 * At the end, return the modified image.
 *
 * Example 1:
 *     Input:
 *         image = [[1,1,1],[1,1,0],[1,0,1]]
 *         sr = 1, sc = 1, newColor = 2
 *     Output: [[2,2,2],[2,2,0],[2,0,1]]
 *     Explanation: From the center of the image (with position (sr, sc) = (1, 1)),
 * all pixels connected by a path of the same color as the starting pixel are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
 */

using System;

namespace Leetcode
{
    internal class Day11_FloodFill
    {
        public static void Main(string[] args)
        {
            Day11_FloodFill test = new Day11_FloodFill();
            int[][] image = new int[3][];
            image[0] = new[] {1, 1, 1};
            image[1] = new[] {1, 1, 0};
            image[2] = new[] {1, 0, 1};
            int sr = 1, sc = 1, newColor = 2;
            int[][] result = test.FloodFill(image, sr, sc, newColor);
            foreach (var element1 in result)
            {
                foreach (var element2 in element1)
                {
                    Console.Write(element2 + "\t");
                }
                Console.WriteLine();
            }
        }
        
        public int[][] FloodFill(int[][] image, int sr, int sc, int newColor) {
            var oldColor = image[sr][sc];
            var rowMax = image.Length - 1;
            var colMax = image[0].Length - 1;

            if(oldColor != newColor) Fill(sr, sc);
            return image;

            void Fill(int row, int col) {
                if(row < 0 || rowMax < row ||
                   col < 0 || colMax < col ||
                   image[row][col] != oldColor) return;

                image[row][col] = newColor;

                Fill(row - 1, col);
                Fill(row + 1, col);
                Fill(row, col - 1);
                Fill(row, col + 1);
            }
        }
    }
}