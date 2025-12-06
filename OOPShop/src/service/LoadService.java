package service;

import model.Product;

public interface LoadService extends VIPBService {

    int STATUS_1 = 1;
    int STATUS_2 = 2;

    void load(Product[] products);

    default int sum(int a, int b){
        return sumAll(a, b);
    }
    default int sum(int a, int b, int c){
        return sumAll(a, b, c);
    }

    private int sumAll(int... values){
        int result = 0;
        for(int n : values){
            result += n;
        }
        return result;
    }
}
