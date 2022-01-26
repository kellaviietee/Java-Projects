
  package ee.taltech.iti0202.idcode;

  import java.util.Calendar;

  public class IdCode {
  
      private final String idCodeValue;
      enum Gender {
          MALE, FEMALE
      }
    
      /**
       * Method returns the id code.
       *
       * @return id code.
       */
      public String getIdCodeValue() {
          return idCodeValue;
      }
    
      public IdCode(String idCodeValue) {
          this.idCodeValue = idCodeValue;
      }

      /**
       * Check if the id code is valid or not.
       *
       * @return boolean describing whether or not the id code was correct.
       */
      public boolean isCorrect() {
          return false;
      }

      /**
       * Get all information about id code.
       * 
       * @return String containing information.
       */
      public String getInformation() {
          return null;
      }

      /**
       * Get gender enum.
       * 
       * @return enum describing person's gender
       */
      public Gender getGender() {
          String idCode = getIdCodeValue();
          int genderNumber = Integer.parseInt(String.valueOf(idCode.charAt(0)));
          if(genderNumber % 2 == 1){
              return Gender.MALE;
          }
          return Gender.FEMALE;
      }

      /**
       * Get person's birth location.
       * 
       * @return String with the person's birth place.
       */
      public String getBirthPlace() {
          return null;
      }

      /**
       * Get the year that the person was born in.
       * 
       * @return int with person's birth year.
       */
      public int getFullYear() {
          String idCode = getIdCodeValue();
          int centuryNumber = Integer.parseInt(String.valueOf(idCode.charAt(0)));
          int century = 0;
          switch (centuryNumber) {
              case 1, 2 -> century = 1800;
              case 3, 4 -> century = 1900;
              case 5, 6 -> century = 2000;
          }
          int yearNumber = Integer.parseInt(idCode.substring(1,3));
          return century + yearNumber;
      }
    
      /**
       * Check if gender number is correct.
       * 
       * @return boolean describing whether the gender number is correct.
       */
      private boolean isGenderNumberCorrect() {
          String idCode = getIdCodeValue();
          int genderNumber = Integer.parseInt(String.valueOf(idCode.charAt(0)));
          return genderNumber >= 1 && genderNumber <= 6;
              }

      /**
       * Check if the year number is correct.
       * 
       * @return boolean describing whether the year number is correct.
       */
      private boolean isYearNumberCorrect() {
          int idYear = getFullYear();
          int currentYear = Calendar.getInstance().get(Calendar.YEAR);
          return idYear >= 1800 && idYear <= currentYear;
      }

      /**
       * Check if the month number is correct.
       * 
       * @return boolean describing whether the month number is correct.
       */
      private boolean isMonthNumberCorrect() {
          String idCode = getIdCodeValue();
          int monthNumber = Integer.parseInt(idCode.substring(3,5));
          return monthNumber >= 1 && monthNumber <= 12;
      }

      /**
       * Check if the day number is correct.
       * 
       * @return boolean describing whether the day number is correct.
       */
      private boolean isDayNumberCorrect() {
          return false;
      }

      /**
       * Check if the control number is correct.
       * 
       * @return boolean describing whether the control number is correct.
       */
      private boolean isControlNumberCorrect() {
          return false;
      }

      /**
       * Check if the given year is a leap year.
       * 
       * @param fullYear is it a normal year or a leap one.
       * @return boolean describing whether the given year is a leap year.
       */
      private boolean isLeapYear(int fullYear) {
          return false;
      }

      /**
       * Run tests.
       * @param args info.
       */
      public static void main(String[] args) {
          IdCode validMaleIdCode = new IdCode("37605030299");
          System.out.println(validMaleIdCode.isCorrect());
          System.out.println(validMaleIdCode.getInformation());
          System.out.println(validMaleIdCode.getGender());
          System.out.println(validMaleIdCode.getBirthPlace());
          System.out.println(validMaleIdCode.getFullYear());
          System.out.println(validMaleIdCode.isGenderNumberCorrect());
          System.out.println(validMaleIdCode.isYearNumberCorrect());
          System.out.println(validMaleIdCode.isMonthNumberCorrect());
          System.out.println(validMaleIdCode.isDayNumberCorrect());
          System.out.println(validMaleIdCode.isControlNumberCorrect());
          System.out.println(validMaleIdCode.isLeapYear(validMaleIdCode.getFullYear()));
      }

  }
