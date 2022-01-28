
  package ee.taltech.iti0202.idcode;

  import java.text.MessageFormat;
  import java.util.Arrays;
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
          try {
              int Value = Integer.parseInt(idCodeValue);
          } catch (NumberFormatException e) {
              throw new IllegalArgumentException();
          }
          try{
              isCorrect();
          } catch (IllegalArgumentException e) {
              e.printStackTrace();
          }
      }

      /**
       * Check if the id code is valid or not.
       *
       * @return boolean describing whether or not the id code was correct.
       */
      public boolean isCorrect() {

          boolean test = isGenderNumberCorrect() && isYearNumberCorrect() && isMonthNumberCorrect() && isDayNumberCorrect() && isControlNumberCorrect();
          if(!test){
              throw new IllegalArgumentException();
          }
          return true;
      }

      /**
       * Get all information about id code.
       * 
       * @return String containing information.
       */
      public String getInformation() {
          String idCode = getIdCodeValue();
          String monthNumber = idCode.substring(3,5);
          String dayNumber = idCode.substring(5,7);
          String year = Integer.toString(getFullYear());
          String gender = getGender().toString();
          String location = getBirthPlace();

          return MessageFormat.format("This is a {0} born on {1}.{2}.{3} in {4}",gender,dayNumber,monthNumber,year,location);
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
          String idCode = getIdCodeValue();
          int birthplaceNumber = Integer.parseInt(idCode.substring(7, 10));
          int year = getFullYear();
          if (year >= 2013) {
              return "unknown";
          } else {
              if (birthplaceNumber >= 1 && birthplaceNumber <= 10) {
                  return "Kuressaare";
              }
              else if (birthplaceNumber >= 11 && birthplaceNumber <= 20) {
                  return "Tartu";
              }
              else if (birthplaceNumber >= 21 && birthplaceNumber <= 220) {
                  return "Tallinn";
              }
              else if (birthplaceNumber >= 221 && birthplaceNumber <= 270) {
                  return "Kohtla-Järve";
              }
              else if (birthplaceNumber >= 271 && birthplaceNumber <= 370) {
                  return "Tartu";
              }
              else if (birthplaceNumber >= 371 && birthplaceNumber <= 420) {
                  return "Narva";
              }
              else if (birthplaceNumber >= 421 && birthplaceNumber <= 470) {
                  return "Pärnu";
              }
              else if (birthplaceNumber >= 471 && birthplaceNumber <= 490) {
                  return "Tallinn";
              }
              else if (birthplaceNumber >= 491 && birthplaceNumber <= 520) {
                  return "Paide";
              }
              else if (birthplaceNumber >= 521 && birthplaceNumber <= 570) {
                  return "Rakvere";
              }
              else if (birthplaceNumber >= 571 && birthplaceNumber <= 600) {
                  return "Valga";
              }
              else if (birthplaceNumber >= 601 && birthplaceNumber <= 650) {
                  return "Viljandi";
              }
              else if (birthplaceNumber >= 651 && birthplaceNumber <= 710) {
                  return "Võru";
              }
              else{
              return "unknown";
              }
          }

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
          String idCode = getIdCodeValue();
          int monthNumber = Integer.parseInt(idCode.substring(3,5));
          int dayNumber = Integer.parseInt(idCode.substring(5,7));
          boolean isItLeapYear = isLeapYear(getFullYear());
          switch (monthNumber) {
              case 1, 3, 5, 7, 8, 10, 12 -> {
                  return dayNumber >= 1 && dayNumber <= 31;
              }
              case 4, 6, 9, 11 -> {
                  return dayNumber >= 1 && dayNumber <= 30;
              }
              case 2 -> {
                  if (isItLeapYear) {
                      return dayNumber >= 1 && dayNumber <= 29;
                  } else {
                      return dayNumber >= 1 && dayNumber <= 28;
                  }
              }
          }
          return false;
      }

      /**
       * Check if the control number is correct.
       * 
       * @return boolean describing whether the control number is correct.
       */
      private boolean isControlNumberCorrect() {
          String idCode = getIdCodeValue();
          int [] idNums = new int[idCode.length()];
          int sum = 0;
          int secondSum = 0;
          for(int i = 0; i < idCode.length() - 1;i++){
              char dummy = idCode.charAt(i);
              int dummyInt = Character.getNumericValue(dummy);
              if(i != 9){sum += (i+1) * dummyInt;}
              else{sum += dummyInt;}
              if (i <= 6){secondSum +=(i + 3) * dummyInt;}
              else{secondSum +=(i - 6) * dummyInt;}
          }
          int controlNumber = sum % 11;
          if (controlNumber == 10){
              controlNumber = secondSum % 11;
              if(controlNumber ==10){controlNumber = 0;}
          }
          int idControlNumber = Character.getNumericValue(idCode.charAt(idCode.length() - 1));
          return controlNumber == idControlNumber;
      }

      /**
       * Check if the given year is a leap year.
       * 
       * @param fullYear is it a normal year or a leap one.
       * @return boolean describing whether the given year is a leap year.
       */
      private boolean isLeapYear(int fullYear) {
          int year = getFullYear();
          if(year % 400 == 0){
              return true;
          }
          else if (year % 100 == 0){
              return false;
          }
          else return year % 4 == 0;
      }

      /**
       * Run tests.
       * @param args info.
       */
      public static void main(String[] args) {
          IdCode validMaleIdCode = new IdCode("abcde");
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
