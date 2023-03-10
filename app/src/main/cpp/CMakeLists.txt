# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.22.1)

# Declares and names the project.

project("bmstu_project")



# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.


add_library(bmstu_project SHARED native-lib.cpp)
add_library(spdlog STATIC IMPORTED)
add_library(mbedcrypto SHARED IMPORTED)

set_target_properties(spdlog PROPERTIES IMPORTED_LOCATION
        C:/Users/Name040220/Desktop/project/BMSTU_SD_project/libs/spdlog/build/x86_64/libspdlog.a)
set_target_properties(mbedcrypto PROPERTIES IMPORTED_LOCATION
        C:/Users/Name040220/Desktop/project/BMSTU_SD_project/app/src/main/nativeLibs/x86_64/libmbedcrypto.so
        )

target_include_directories(bmstu_project PUBLIC
        C:/Users/Name040220/Desktop/project/BMSTU_SD_project/libs/spdlog/spdlog/include
        C:/Users/Name040220/Desktop/project/BMSTU_SD_project/libs/mbedits/mbedtls/include)

target_link_libraries( # Specifies the target library.
        bmstu_project
        spdlog
        mbedcrypto
        log)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

