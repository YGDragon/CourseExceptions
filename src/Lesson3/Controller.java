package Lesson3;

public class Controller {
    public static void main(String[] args) throws Exception {
        //вступительный блок
        View.dataMessage(Model.titleData);
        String[] checkedData = Model.checkPersonData(
                Model.enterData()
        );

        //блок записи персональных данных в файл
        try {
            assert checkedData != null;
            Model.personDataWrite(
                    checkedData, Model.isFileExists(checkedData[0])
            );
            View.writeMessage();
        } catch (NullPointerException ex) {
            View.writeNotMessage();
        }
    }
}