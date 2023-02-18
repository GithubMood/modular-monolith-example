package com.monolith.example;

import com.example.util.time.Time;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import java.time.*;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;
import static com.tngtech.archunit.library.GeneralCodingRules.*;

@AnalyzeClasses(
        packages = "com.monolith.example",
        importOptions = ImportOption.DoNotIncludeTests.class
)
class ArchitectureRulesTest {
    @ArchTest
    //Actually this test enforces module dependency rules (not the layer architecture rules)
    //Layers are used as there are no "module" abstraction in the ArchUnit where we can hide packages
    public static final ArchRule MODULE_ARCHITECTURE_RULE = layeredArchitecture()
            .consideringAllDependencies()
            .layer("iam-api").definedBy("com.monolith.example.iam.api..")
            .layer("iam-impl").definedBy("com.monolith.example.iam.impl..")
//            .layer("writing-api").definedBy("com.monolith.example.writing.api..")
            .layer("writing-impl").definedBy("com.monolith.example.writing.impl..")
//            .layer("publishing-api").definedBy("com.monolith.example.publishing.api..")
//            .layer("publishing-impl").definedBy("com.monolith.example.publishing.impl..")

            .whereLayer("iam-impl").mayNotBeAccessedByAnyLayer()
            .whereLayer("writing-impl").mayNotBeAccessedByAnyLayer();
//            .whereLayer("publishing-impl").mayNotBeAccessedByAnyLayer();

    @ArchTest
    public static final ArchRule RESTRICT_USAGE_OF_LOCAL_DATE_TIME_NOW = noClasses()
            .should().callMethod(LocalDateTime.class, "now")
            .because("Use Time.currentDateTime methods instead of as it gives opportunity of mocking time in tests");

    @ArchTest
    public static final ArchRule RESTRICT_USAGE_OF_LOCAL_DATE_NOW = noClasses()
            .should().callMethod(LocalDate.class, "now")
            .because("Use Time.currentDate methods instead of as it gives opportunity of mocking time in tests");

    @ArchTest
    public static final ArchRule RESTRICT_USAGE_OF_LOCAL_TIME_NOW = noClasses()
            .should().callMethod(LocalTime.class, "now")
            .because("Use Time.currentTime methods instead of as it gives opportunity of mocking time in tests");

    @ArchTest
    public static final ArchRule RESTRICT_USAGE_OF_OFFSET_DATE_TIME_NOW = noClasses()
            .should().callMethod(OffsetDateTime.class, "now")
            .because("Use Time.currentOffsetDateTime methods instead of "
                    + "as it gives opportunity of mocking time in tests");

    @ArchTest
    public static final ArchRule RESTRICT_USAGE_OF_ZONED_DATE_TIME_NOW = noClasses()
            .should().callMethod(ZonedDateTime.class, "now")
            .because("Use Time.currentZonedDateTime methods instead of as it gives "
                    + "opportunity of mocking time in tests");

    @ArchTest
    public static final ArchRule RESTRICT_USAGE_OF_INSTANT_NOW = noClasses()
            .should().callMethod(Instant.class, "now")
            .because("Use Time.currentInstant methods instead of as it gives opportunity of mocking time in tests");

    @ArchTest
    public static final ArchRule RESTRICT_TIME_MOCKING = noClasses()
            .that().resideOutsideOfPackages("com.monolith.example.*.test.*")
            .should().callMethod(Time.class, "useMockTime", LocalDateTime.class, ZoneId.class)
            .because("Method Time.useMockTime designed only for test purpose and can be used only in the tests");

    @ArchTest
    public static final ArchRule RESTRICT_STANDARD_STREAM_USAGE = NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;

    @ArchTest
    public static final ArchRule RESTRICT_JAVA_UTIL_LOGGING_USAGE = NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING;

    @ArchTest
    public static final ArchRule RESTRICT_JODATIME_USAGE = NO_CLASSES_SHOULD_USE_JODATIME;

    @ArchTest
    private final ArchRule NO_GENERIC_EXCEPTIONS = NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;
}
