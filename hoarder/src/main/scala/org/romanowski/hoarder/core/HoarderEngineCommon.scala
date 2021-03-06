/*
 * Hoarder - Cached compilation plugin for sbt.
 * Copyright 2016 - 2017, Krzysztof Romanowski
 * This software is released under the terms written in LICENSE.
 */

package org.romanowski.hoarder.core

import java.nio.file.Path

import org.romanowski.HoarderKeys._
import org.romanowski.hoarder.core.SbtTypes.CompilationResult
import org.romanowski.hoarder.core.SbtTypes.PreviousCompilationResult

trait HoarderEngineCommon {
  val analysisCacheFileName = "analysis.txt"
  val analysisCacheZipFileName = "analysis.zip"
  val classesZipFileName = "classes.zip"

  protected def exportCacheTaskImpl(setup: CacheSetup,
                                    result: CompilationResult,
                                    globalCacheLocation: Path): ExportedCache

  protected final def exportCacheTaskImpl(globalCacheLocation: Path)(setup: ExportCacheSetup): ExportedCache =
    exportCacheTaskImpl(setup.cacheSetup, setup.compilationResult, globalCacheLocation)


  protected def importCacheTaskImpl(cacheSetup: CacheSetup, globalCacheLocation: Path): Option[PreviousCompilationResult]
}