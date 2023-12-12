package manager;


import model.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ProviderData {

    @DataProvider
    public Iterator<Object[]> userDtoCSVregPositiv()  {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader
                    (new File("src/test/resources/reg_dataset.csv")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new User()

                    .withEmail(split[0])
                    .withPassword(split[1])
            });
            try {
                line = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> userDTO_CSVregNegativEmail() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader
                (new FileReader(new File("src/test/resources/reg_neg_email_dataset.csv")));
        String line = reader.readLine();
        while (line != null){
            String[] split = line.split(",");
            list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> userDTO_CSVregNegativPassword() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader
                (new FileReader(new File("src/test/resources/reg_neg_password_dataset.csv")));
        String line = reader.readLine();
        while (line != null){
            String[] split = line.split(",");
            list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> userDTOCSVLogin() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader
                (new FileReader(new File("src/test/resources/login_dataset.csv")));
        String line = reader.readLine();
        while (line != null){
            String[] split = line.split(",");
            list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }


}



