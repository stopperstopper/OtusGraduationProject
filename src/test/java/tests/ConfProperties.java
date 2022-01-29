package tests;
/**
 *@author  Садыков Александр
 * Чтение настроек из conf.properties
 * Возврат значения запрошенной настройки
 */
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ConfProperties {
    public static  Logger logger = LogManager.getLogger(ConfProperties.class);
    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;
    static {
        try {
            //указание пути до файла с настройками
            fileInputStream = new FileInputStream("src/main/resources/conf.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("Проверьте пути log файла");       } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.info("Ошибка закрытия log файла");
                } } }

    // метод для возврата строки со значением из файла с настройками 

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key); } }
