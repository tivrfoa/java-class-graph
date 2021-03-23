package com.lsc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.lsc.domain.Cat;
import com.lsc.domain.Dog;
import com.lsc.domain.Person;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;

/**
 * Testing classgraph
 *
 */
public class App 
{
    Person joe;
    Dog duck;
    Cat miau;
    public static void main( String[] args )
    {
        testClassGraph();
    }

    private static void testClassGraph() {
        String pkg = "com.lsc";
        try (ScanResult scanResult =
                new ClassGraph()
                    .verbose()               // Log to stderr
                    .enableAllInfo()         // Scan classes, methods, fields, annotations
                    .enableInterClassDependencies()
                    .acceptPackages(pkg)     // Scan com.xyz and subpackages (omit to scan all packages)
                    .scan()) {               // Start the scan
            ClassInfoList allClasses = scanResult.getAllClasses();
            try {
                // then dot -Tsvg < classgraph.dot > classgraph.svg
                String generateGraphVizDotFile = allClasses.generateGraphVizDotFile(500, 500);
                Files.write(Paths.get("classgraph.dot"), generateGraphVizDotFile.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

