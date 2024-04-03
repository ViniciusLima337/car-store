package br.com.carstore.dao;

import br.com.carstore.model.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CarDao {

    public void createCar(Car car) {

        String SQL = "INSERT INTO CAR (NAME) VALUES (?)";


        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");


            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, car.getName());
            preparedStatement.execute();

            System.out.println("Sucesso ao gravar o nome do carro no banco");

            connection.close();

        } catch (Exception e) {

            System.out.println("Erro ao salva");

        }

    }

}