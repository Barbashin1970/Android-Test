<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
<div align="center">
<h2 align="center">Android Appium Test</h2>
  <p align="center">
    Java / Maven / Appium / Android Studio / Junit5 / Allure-report
  </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>

  </ol>
</details>

<!-- ABOUT THE PROJECT -->

**Особенности:**

- Автотесты на JUnit5 более эффективны чем на JUnit4
- Андроид-приложение запускается в эмуляторе при помощи Android-Studio
- Appium GUI запускается в фоновом режиме
- тесты работают с открытием приложения login.apk на экране эмулятора Андроид 10
- закрытие экрана происходит один раз по окончании всех тестов


**Все позитивные сценарии:**

- страница авторизации отображается;
- авторизация по верному логину и паролю приводит к успеху;



**Все негативные сценарии:**

- авторизация по невалидному паролю приводит к ошибке;

### Built With

* <a href="https://www.java.com/ru/">Java 11</a>
* <a href="https://junit.org/junit5/docs/current/user-guide/">Junit 5</a>
* <a href="https://appium.io/docs/en/2.0/">Appium</a>
* <a href="https://github.com/allure-framework/">Allure Framework</a>