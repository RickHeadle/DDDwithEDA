package ru.rickheadle.dddwitheda.application.archunit;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

class ArchunitApplicationTest {

  private JavaClasses importedClasses;

  @BeforeEach
  public void setup() {
    importedClasses = new ClassFileImporter()
        .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
        .importPackages("ru.rickheadle.dddwitheda");
  }

  /*    Package Dependency Checks*/

  @Test
  void servicesAndRepositoriesShouldNotDependOnWebLayer() {

    noClasses()
        .that().resideInAnyPackage("ru.rickheadle.dddwitheda.application.services..")
        .or().resideInAnyPackage("ru.rickheadle.dddwitheda.repository..")
        .should()
        .dependOnClassesThat()
        .resideInAnyPackage("ru.rickheadle.dddwitheda.controller..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
  }

  /* Class Dependency Checks*/

  @Test
  void serviceClassesShouldOnlyBeAccessedByController() {
    classes()
        .that().resideInAPackage("..services..")
        .should().onlyBeAccessed()
          .byAnyPackage("..services..", "..controller..", "..mapper..")
        .check(importedClasses);
  }


  /* naming convention */

  @Test
  void serviceClassesShouldBeNamedXServiceOrXComponentOrXServiceImpl() {
    classes()
        .that().resideInAPackage("..services..")
        .should().haveSimpleNameEndingWith("Service")
        .orShould().haveSimpleNameEndingWith("ServiceImpl")
        .orShould().haveSimpleNameEndingWith("Component")
        .check(importedClasses);
  }

  @Test
  void repositoryClassesShouldBeNamedXRepository() {
    classes()
        .that().resideInAPackage("..repository..")
        .should().haveSimpleNameEndingWith("Repository")
        .check(importedClasses);
  }

  @Test
  void controllerClassesShouldBeNamedXController() {
    classes()
        .that().resideInAPackage("..controller..")
        .should().haveSimpleNameEndingWith("Controller")
        .check(importedClasses);
  }


  /* Annotation check*/

  @Test
  void repositoryClassesShouldHaveSpringRepositoryAnnotation() {
    classes()
        .that().resideInAPackage("..repository..")
        .should().beAnnotatedWith(Repository.class)
        .check(importedClasses);
  }

  @Test
  void serviceClassesShouldHaveSpringServiceAnnotation() {
    classes()
        .that().resideInAPackage("..services.impl")
        .should().beAnnotatedWith(Service.class)
        .check(importedClasses);
  }

  /*    Layer Dependency Rules Test*/
  @Test
  void layeredArchitectureShouldBeRespected() {

    layeredArchitecture()
        .consideringOnlyDependenciesInLayers()
        .layer("Controller").definedBy("..controller..")
        .layer("Service").definedBy("..services..")
        .layer("Repository").definedBy("..repository..")

        .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
        .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
        .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service")
        .check(importedClasses);
  }

  @Test
  void repositoriesMustResideInRepositoryPackage() {
    classes().that().haveNameMatching(".*Repository").should().resideInAPackage("..repository..")
        .as("Repositories should reside in a package '..repository..'")
        .check(importedClasses);
  }

  @Test
  void interfacesShouldNotHaveNamesEndingWithTheWordInterface() {
    noClasses().that().areInterfaces().should().haveNameMatching(".*Interface").check(importedClasses);
  }

  @Test
  void domainClassesShouldBePublic() {
    classes()
        .that().resideInAPackage("..domain..")
        .should()
        .bePublic()
        .check(importedClasses);
  }

}