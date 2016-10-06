

// emulate this: https://github.com/TrueCar/mleap/blob/master/build.sbt

// Set sub-project on SBT start: http://stackoverflow.com/a/22240142/1007926
// onLoad in Global := {
//   Command.process("project distributions", _: State)
// } compose (onLoad in Global).value

// Task 5h





lazy val root: Project = (project in file("."))
	.settings(Common.commonSettings:_*)
	.aggregate(distributions)
	.aggregate(plotting)

lazy val distributions: Project = (project in file("distributions"))
	.settings(Common.commonSettings:_*)

lazy val plotting: Project = (project in file("plotting"))
	.settings(Common.commonSettings:_*)
	.settings(libraryDependencies ++= Dependencies.plottingDependencies)
	.dependsOn(distributions)