/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tirellis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import javax.swing.JFrame;

public class NewClass1 extends JFrame {

    Koordinat[][] koordinatlar = new Koordinat[4][6];
    Koordinat[][] degerler = new Koordinat[4][6];
    int[] g1 = new int[3];
    int[] g2 = new int[3];
    int[] gi = new int[5];
    int[] git = new int[5];

    public NewClass1(int gelen_g1[], int gelen_g2[], int gelen_g3[], int gelen_g4[]) {
        setSize(1200, 750);
        setDefaultCloseOperation(NewClass1.EXIT_ON_CLOSE);
        setVisible(true);
        g1 = gelen_g1;
        g2 = gelen_g2;
        gi = gelen_g3;
        git = gelen_g4;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                koordinatlar[i][j] = new Koordinat();
                degerler[i][j] = new Koordinat();
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                koordinatlar[i][j].x = i * 200 + 100;
                koordinatlar[i][j].y = j * 200 + 100;
            }
        }

    }

    @Override
    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setColor(Color.gray);
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.setStroke(dashed);

        for (int i = 0; i < 4; i++) {
            g2d.drawLine(koordinatlar[i][0].y, koordinatlar[i][0].x, koordinatlar[i][5].y, koordinatlar[i][5].x);
        }
        for (int i = 0; i < 6; i++) {
            g2d.drawLine(koordinatlar[0][i].y, koordinatlar[0][i].x, koordinatlar[3][i].y, koordinatlar[3][i].x);
        }

        g2d.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        g2d.drawString("00", koordinatlar[0][0].y - 50, koordinatlar[0][0].x + 10);

        g2d.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        g2d.drawString("10", koordinatlar[1][0].y - 50, koordinatlar[1][0].x + 10);

        g2d.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        g2d.drawString("01", koordinatlar[2][0].y - 50, koordinatlar[2][0].x + 10);

        g2d.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        g2d.drawString("11", koordinatlar[3][0].y - 50, koordinatlar[3][0].x + 10);

        int maliyet;
        int[][] sonuc = new int[6][2];
        sonuc = bul(g1, g2, gi,git);

        Stroke dashed2 = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);

        for (int j = 0; j < 5; j++) {
            g2d.setColor(Color.red);
            g2d.setStroke(new BasicStroke(2));
            g2d.drawLine(koordinatlar[0][j].y, koordinatlar[0][j].x, koordinatlar[0][j + 1].y, koordinatlar[0][j + 1].x);
            g2d.setColor(Color.red);
            g2d.setFont(new Font("TimesRoman", Font.PLAIN, 15));
            g2d.drawString("00", koordinatlar[0][j].y + 10, koordinatlar[0][j].x - 10);

            g2d.setColor(Color.BLUE);
            g2d.setFont(new Font("TimesRoman", Font.PLAIN, 25));
            maliyet = Math.abs(sonuc[j][0] - 0) + Math.abs(sonuc[j][1] - 0);
            g2d.drawString(maliyet + "", koordinatlar[0][j].y + 60, koordinatlar[0][j].x - 10);

            g2d.setColor(Color.red);
            g2d.setStroke(dashed2);
            g2d.drawLine(koordinatlar[0][j].y, koordinatlar[0][j].x, koordinatlar[1][j + 1].y, koordinatlar[1][j + 1].x);
            g2d.setColor(Color.red);
            g2d.setFont(new Font("TimesRoman", Font.PLAIN, 15));
            g2d.drawString("11", koordinatlar[0][j].y + 10, koordinatlar[0][j].x + 40);

            g2d.setColor(Color.BLUE);
            g2d.setFont(new Font("TimesRoman", Font.PLAIN, 25));
            maliyet = Math.abs(sonuc[j][0] - 1) + Math.abs(sonuc[j][1] - 1);
            g2d.drawString(maliyet + "", koordinatlar[0][j].y + 60, koordinatlar[0][j].x + 50);
        }

        for (int j = 1; j < 5; j++) {
            g2d.setColor(Color.red);
            g2d.setStroke(new BasicStroke(2));
            g2d.drawLine(koordinatlar[1][j].y, koordinatlar[1][j].x, koordinatlar[2][j + 1].y, koordinatlar[2][j + 1].x);
            g2d.setColor(Color.red);
            g2d.setFont(new Font("TimesRoman", Font.PLAIN, 15));
            g2d.drawString("10", koordinatlar[1][j].y + 15, koordinatlar[1][j].x + 15);

            g2d.setColor(Color.BLUE);
            g2d.setFont(new Font("TimesRoman", Font.PLAIN, 25));
            maliyet = Math.abs(sonuc[j][0] - 1) + Math.abs(sonuc[j][1] - 0);
            g2d.drawString(maliyet + "", koordinatlar[1][j].y + 50, koordinatlar[1][j].x + 45);

            g2d.setColor(Color.red);
            g2d.setStroke(dashed2);
            g2d.drawLine(koordinatlar[1][j].y, koordinatlar[1][j].x, koordinatlar[3][j + 1].y, koordinatlar[3][j + 1].x);
            g2d.setColor(Color.red);
            g2d.setFont(new Font("TimesRoman", Font.PLAIN, 15));
            g2d.drawString("01", koordinatlar[1][j].y + 10, koordinatlar[1][j].x + 60);

            g2d.setColor(Color.BLUE);
            g2d.setFont(new Font("TimesRoman", Font.PLAIN, 25));
            maliyet = Math.abs(sonuc[j][0] - 0) + Math.abs(sonuc[j][1] - 1);
            g2d.drawString(maliyet + "", koordinatlar[1][j].y + 25, koordinatlar[1][j].x + 75);

        }

        for (int j = 2; j < 5; j++) {
            g2d.setColor(Color.red);
            g2d.setStroke(new BasicStroke(2));
            g2d.drawLine(koordinatlar[2][j].y, koordinatlar[2][j].x, koordinatlar[0][j + 1].y, koordinatlar[0][j + 1].x);
            g2d.setColor(Color.red);
            g2d.setFont(new Font("TimesRoman", Font.PLAIN, 15));
            g2d.drawString("11", koordinatlar[2][j].y + 10, koordinatlar[2][j].x - 50);

            g2d.setColor(Color.BLUE);
            g2d.setFont(new Font("TimesRoman", Font.PLAIN, 25));
            maliyet = Math.abs(sonuc[j][0] - 1) + Math.abs(sonuc[j][1] - 1);
            g2d.drawString(maliyet + "", koordinatlar[2][j].y + 25, koordinatlar[2][j].x - 70);

            g2d.setColor(Color.red);
            g2d.setStroke(dashed2);
            g2d.drawLine(koordinatlar[2][j].y, koordinatlar[2][j].x, koordinatlar[1][j + 1].y, koordinatlar[1][j + 1].x);
            g2d.setColor(Color.red);
            g2d.setFont(new Font("TimesRoman", Font.PLAIN, 15));
            g2d.drawString("00", koordinatlar[2][j].y + 15, koordinatlar[2][j].x - 5);

            g2d.setColor(Color.BLUE);
            g2d.setFont(new Font("TimesRoman", Font.PLAIN, 25));
            maliyet = Math.abs(sonuc[j][0] - 0) + Math.abs(sonuc[j][1] - 0);
            g2d.drawString(maliyet + "", koordinatlar[2][j].y + 40, koordinatlar[2][j].x - 25);
        }

        for (int j = 2; j < 5; j++) {
            g2d.setColor(Color.red);
            g2d.setStroke(new BasicStroke(2));
            g2d.drawLine(koordinatlar[3][j].y, koordinatlar[3][j].x, koordinatlar[2][j + 1].y, koordinatlar[2][j + 1].x);
            g2d.setColor(Color.red);
            g2d.setFont(new Font("TimesRoman", Font.PLAIN, 15));
            g2d.drawString("01", koordinatlar[3][j].y + 10, koordinatlar[3][j].x - 25);

            g2d.setColor(Color.BLUE);
            g2d.setFont(new Font("TimesRoman", Font.PLAIN, 25));
            maliyet = Math.abs(sonuc[j][0] - 0) + Math.abs(sonuc[j][1] - 1);
            g2d.drawString(maliyet + "", koordinatlar[3][j].y + 35, koordinatlar[3][j].x - 50);

            g2d.setColor(Color.red);
            g2d.setStroke(dashed2);
            g2d.drawLine(koordinatlar[3][j].y, koordinatlar[3][j].x, koordinatlar[3][j + 1].y, koordinatlar[3][j + 1].x);
            g2d.setColor(Color.red);
            g2d.setFont(new Font("TimesRoman", Font.PLAIN, 15));
            g2d.drawString("11", koordinatlar[3][j].y + 10, koordinatlar[3][j].x + 15);

            g2d.setColor(Color.BLUE);
            g2d.setFont(new Font("TimesRoman", Font.PLAIN, 25));
            maliyet = Math.abs(sonuc[j][0] - 1) + Math.abs(sonuc[j][1] - 1);
            g2d.drawString(maliyet + "", koordinatlar[3][j].y + 45, koordinatlar[3][j].x + 15);
        }

        for (int i = 0; i < 5; i++) {
            String tut = "";
            tut += sonuc[i][0];
            tut += sonuc[i][1];
            g2d.setColor(Color.darkGray);
            g2d.setFont(new Font("TimesRoman", Font.PLAIN, 25));
            g2d.drawString(tut, koordinatlar[0][i].y + 60, koordinatlar[0][i].x - 40);
        }

    }

    public int[][] bul(int g1[], int g2[], int input[],int git[]) {
        int[][] sonuc = new int[5][2];
        sonuc[0][0] = ((int) input[0] * g1[0] + (int) 0 * g1[1] + (int) 0 * g1[2]) % 2;
        sonuc[0][1] = ((int) input[0] * g2[0] + (int) 0 * g2[1] + (int) 0 * g2[2]) % 2;
        sonuc[1][0] = ((int) input[1] * g1[0] + (int) input[0] * g1[1] + (int) 0 * g1[2]) % 2;
        sonuc[1][1] = ((int) input[1] * g2[0] + (int) input[0] * g2[1] + (int) 0 * g2[2]) % 2;
        sonuc[2][0] = ((int) input[2] * g1[0] + (int) input[1] * g1[1] + (int) input[0] * g1[2]) % 2;
        sonuc[2][1] = ((int) input[2] * g2[0] + (int) input[1] * g2[1] + (int) input[0] * g2[2]) % 2;
        sonuc[3][0] = ((int) input[3] * g1[0] + (int) input[2] * g1[1] + (int) input[1] * g1[2]) % 2;
        sonuc[3][1] = ((int) input[3] * g2[0] + (int) input[2] * g2[1] + (int) input[1] * g2[2]) % 2;
        sonuc[4][0] = ((int) input[4] * g1[0] + (int) input[3] * g1[1] + (int) input[2] * g1[2]) % 2;
        sonuc[4][1] = ((int) input[4] * g2[0] + (int) input[3] * g2[1] + (int) input[2] * g2[2]) % 2;
//        sonuc[5][0] = ((int) input[5] * g1[0] + (int) input[4] * g1[1] + (int) input[3] * g1[2]) % 2;
//        sonuc[5][1] = ((int) input[5] * g2[0] + (int) input[4] * g2[1] + (int) input[3] * g2[2]) % 2;

        Koordinat[][] matris = new Koordinat[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matris[i][j] = new Koordinat();
            }
        }

        matris[0][0].x = sonuc[0][0];
        matris[0][0].y = sonuc[0][1];
        matris[0][1].x = sonuc[1][0];
        matris[0][1].y = sonuc[1][1];
        matris[0][2].x = sonuc[2][0];
        matris[0][2].y = sonuc[2][1];
        matris[0][3].x = sonuc[3][0];
        matris[0][3].y = sonuc[3][1];
        matris[0][4].x = sonuc[4][0];
        matris[0][4].y = sonuc[4][1];

        matris[1][0].x = 0;
        matris[1][0].y = 0;
        matris[1][1].x = sonuc[0][0];
        matris[1][1].y = sonuc[0][1];
        matris[1][2].x = sonuc[1][0];
        matris[1][2].y = sonuc[1][1];
        matris[1][3].x = sonuc[2][0];
        matris[1][3].y = sonuc[2][1];
        matris[1][4].x = sonuc[3][0];
        matris[1][4].y = sonuc[3][1];

        matris[2][0].x = 0;
        matris[2][0].y = 0;
        matris[2][1].x = 0;
        matris[2][1].y = 0;
        matris[2][2].x = sonuc[0][0];
        matris[2][2].y = sonuc[0][1];
        matris[2][3].x = sonuc[1][0];
        matris[2][3].y = sonuc[1][1];
        matris[2][4].x = sonuc[2][0];
        matris[2][4].y = sonuc[2][1];

        matris[3][0].x = 0;
        matris[3][0].y = 0;
        matris[3][1].x = 0;
        matris[3][1].y = 0;
        matris[3][2].x = 0;
        matris[3][2].y = 0;
        matris[3][3].x = sonuc[0][0];
        matris[3][3].y = sonuc[0][1];
        matris[3][4].x = sonuc[1][0];
        matris[3][4].y = sonuc[1][1];

        matris[4][0].x = 0;
        matris[4][0].y = 0;
        matris[4][1].x = 0;
        matris[4][1].y = 0;
        matris[4][2].x = 0;
        matris[4][2].y = 0;
        matris[4][3].x = 0;
        matris[4][3].y = 0;
        matris[4][4].x = sonuc[0][0];
        matris[4][4].y = sonuc[0][1];

//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                System.out.print(matris[i][j].x + "," + matris[i][j].y + "   ");
//            }
//        }
        
//        for (int i = 0; i < 5; i++) {
//            System.out.println(git[i]);
//        }

        int[][] o_sonuc = new int[5][2];

        o_sonuc[0][0] = (git[0] * matris[0][0].x + git[1] * matris[1][0].x + git[2] * matris[2][0].x + git[3] * matris[3][0].x + git[4] * matris[4][0].x) % 2;
        o_sonuc[0][1] = (git[0] * matris[0][0].y + git[1] * matris[1][0].y + git[2] * matris[2][0].y + git[3] * matris[3][0].y + git[4] * matris[4][0].y) % 2;
        o_sonuc[1][0] = (git[0] * matris[0][1].x + git[1] * matris[1][1].x + git[2] * matris[2][1].x + git[3] * matris[3][1].x + git[4] * matris[4][1].x) % 2;
        o_sonuc[1][1] = (git[0] * matris[0][1].y + git[1] * matris[1][1].y + git[2] * matris[2][1].y + git[3] * matris[3][1].y + git[4] * matris[4][1].y) % 2;
        o_sonuc[2][0] = (git[0] * matris[0][2].x + git[1] * matris[1][2].x + git[2] * matris[2][2].x + git[3] * matris[3][2].x + git[4] * matris[4][2].x) % 2;
        o_sonuc[2][1] = (git[0] * matris[0][2].y + git[1] * matris[1][2].y + git[2] * matris[2][2].y + git[3] * matris[3][2].y + git[4] * matris[4][2].y) % 2;
        o_sonuc[3][0] = (git[0] * matris[0][3].x + git[1] * matris[1][3].x + git[2] * matris[2][3].x + git[3] * matris[3][3].x + git[4] * matris[4][3].x) % 2;
        o_sonuc[3][1] = (git[0] * matris[0][3].y + git[1] * matris[1][3].y + git[2] * matris[2][3].y + git[3] * matris[3][3].y + git[4] * matris[4][3].y) % 2;
        o_sonuc[4][0] = (git[0] * matris[0][4].x + git[1] * matris[1][4].x + git[2] * matris[2][4].x + git[3] * matris[3][4].x + git[4] * matris[4][4].x) % 2;
        o_sonuc[4][1] = (git[0] * matris[0][4].y + git[1] * matris[1][4].y + git[2] * matris[2][4].y + git[3] * matris[3][4].y + git[4] * matris[4][4].y) % 2;
        return o_sonuc;
    }
}

class Koordinat {
    int x;
    int y;
}
