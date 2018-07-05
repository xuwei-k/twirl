
logLevel := Level.Debug

lazy val root = (project in file("."))
  .enablePlugins(ScalaJSPlugin, SbtTwirl)
  .settings(
    libraryDependencies ++= {
      CrossVersion.partialVersion(scalaVersion.value) match {
        case Some((2, v)) if v >= 11 =>
          Seq("org.scala-lang.modules" %%% "scala-xml" % "1.1.0")
        case _ =>
          Nil
      }
    },
    scalaJSUseMainModuleInitializer := true,
    mainClass := Some("Test")
  )
