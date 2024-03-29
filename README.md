<h1 align="center">ClippedCircleShape😇</h1></br>
<p align="center">Clipped circle shape in jetpack compose</p>

[![](https://jitpack.io/v/JustinGeorgeJoseph/ClippedCircleShape.svg)](https://jitpack.io/#JustinGeorgeJoseph/ClippedCircleShape)


<p align="center"><img src="/demo/sample.png"/></p>

## Description or Motivation 💡
Facebook uses a row of profile images in a circle shape in the mutual friend’s section.🤞🏻

## Usage
`ClippedCircleShape` has 4 options to handle the clipping direction(`ClipDirection`)
- START
- END
- RIGHT
- BOTTOM
<p align="center"><img src="/demo/showcase.png" /></p>

## Including in your project
### Gradle 
```
dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
```
And add a dependency code to your **module**'s `build.gradle` file.
```
dependencies {
    implementation 'com.github.JustinGeorgeJoseph:ClippedCircleShape:Tag'
}
```
## Example
Here I am using `ClippedCircleShape(clipDirection = ClipDirection.START)`
```
Image(
    painter = painterResource(id = R.drawable.b),
    contentDescription = null,
    modifier = Modifier
      .size(60.dp)
      .clip(ClippedCircleShape(clipDirection = ClipDirection.START))
)
```

## 😍😍😍
<p align="center"><img src="/demo/example.png"/></p>
