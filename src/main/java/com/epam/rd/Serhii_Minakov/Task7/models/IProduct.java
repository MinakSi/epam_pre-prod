package com.epam.rd.Serhii_Minakov.Task7.models;

public interface IProduct {

    int getId();

    double getPrice();

    void setPrice(double price);

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    int getAmountOnStorage();

    void setAmountOnStorage(int amountOnStorage);
}
