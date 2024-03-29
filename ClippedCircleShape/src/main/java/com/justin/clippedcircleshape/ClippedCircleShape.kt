package com.justin.clippedcircleshape

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.toRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathOperation
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

enum class ClipDirection {
    START, TOP, END, BOTTOM
}

class ClippedCircleShape(val clipDirection: ClipDirection = ClipDirection.START) : Shape {

    private companion object {
        const val DELTA_SPACE = .15F
    }

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {

        val roundRectPath = Path().apply {
            addRoundRect(roundRect = getRoundRect(rect = size.toRect()))
        }

        val arcPath = Path().apply {
            val offset = when (clipDirection) {
                ClipDirection.START -> Offset(
                    x = -size.width + (size.width * DELTA_SPACE),
                    y = Offset.Zero.y
                )

                ClipDirection.END -> Offset(
                    x = size.width - (size.width * DELTA_SPACE),
                    y = Offset.Zero.y
                )

                ClipDirection.TOP -> Offset(
                    x = Offset.Zero.x,
                    y = -size.width + (size.height * DELTA_SPACE)
                )

                ClipDirection.BOTTOM -> Offset(
                    x = Offset.Zero.x,
                    y = size.width - (size.height * DELTA_SPACE)
                )
            }
            val clipRect = Rect(
                offset = offset,
                size = Size(
                    width = Offset.Zero.x + size.width,
                    height = Offset.Zero.y + size.height
                )
            )
            addRoundRect(roundRect = getRoundRect(rect = clipRect))
        }

        return Outline.Generic(
            Path.combine(
                operation = PathOperation.Difference,
                path1 = roundRectPath,
                path2 = arcPath
            )
        )
    }

    private fun getRoundRect(rect: Rect) =
        RoundRect(rect = rect, radiusX = rect.height / 2f, radiusY = rect.height / 2f)
}

private class ClipDirectionProvider : PreviewParameterProvider<ClipDirection> {
    override val values = ClipDirection.entries.asSequence()
}

@Preview
@Composable
private fun ClippedCircleShapePreview(
    @PreviewParameter(ClipDirectionProvider::class) clipDirection: ClipDirection
) {
    Box(
        Modifier
            .defaultMinSize(
                minWidth = 100.dp,
                minHeight = 100.dp
            )
            .background(Color.Gray, shape = ClippedCircleShape(clipDirection = clipDirection))
            .clip(ClippedCircleShape(clipDirection = clipDirection))
            .padding(4.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "+9",
            maxLines = 1,
            color = Color.White,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Start,
        )
    }
}