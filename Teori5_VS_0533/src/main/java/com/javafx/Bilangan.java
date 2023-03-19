package com.javafx;

public class Bilangan {
    private double[] data;
    private int cacah;
    private String record;

    Bilangan(int size) {
        this.cacah = 0;
        this.data = new double[size];
        this.record = "";
    }

    public void deleteData() {
        cacah--;
        double[] temp = null;
        temp = new double[data.length - 1];
        for (int i = 0; i < data.length - 1; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public void growSize() {
        double[] temp = null;
        if (cacah == data.length) {
            temp = new double[data.length + 1];
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
        }
        data = temp;
    }

    public void add(double input) {
        if (cacah == data.length) {
            growSize();
        }
        this.data[cacah] = input;
        cacah++;
    }

    public String getArray() {
        String array = "";
        for (int i = 0; i < this.data.length; i++) {
            array += data[i] + " ";
        }
        return array;
    }

    public void bubbleSort() {
        this.record = "";
        double temp;
        for (int cycle = 1; cycle < this.data.length; cycle++) {
            for (int compare = 0; compare < (this.data.length - cycle); compare++) {
                if (this.data[compare] > this.data[compare + 1]) {
                    temp = this.data[compare];
                    this.data[compare] = this.data[compare+1];
                    this.data[compare+1] = temp;
                }
                this.record += cycle + ", " + String.valueOf(compare+1) + " --> " + getArray() + "\n";
            }
            this.record+="\n";
        }
    }

    public String getProses() {
        String test = this.record;
        return test;
    }

}
