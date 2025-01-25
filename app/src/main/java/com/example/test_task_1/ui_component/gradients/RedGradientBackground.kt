import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

fun Modifier.RedGradientBackground(): Modifier {
    return this.then(
        Modifier.drawWithContent {
            drawRect(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFEC5F5F).copy(alpha = 0.8f),
                        Color(0xFFDC3939),
                        Color(0xFFEA1414)
                    ),
                    start = Offset(0f, size.height / 2),
                    end = Offset(size.width, size.height / 2)
                )
            )
            drawContent()
        }
    )
}

fun gradientTextStyle(): TextStyle {

    return TextStyle(
        fontWeight = FontWeight.Bold,
        brush = Brush.linearGradient(
            colors = listOf(
                Color(0xFFEC5F5F).copy(alpha = 0.8f),
                Color(0xFFDC3939),
                Color(0xFFEA1414)
            ),
            start = Offset(0f, 30f),
            end = Offset(400f, 0f)
        )
    )
}

fun gradientBrushStyle(): Brush {
    return Brush.linearGradient(
        colors = listOf(
            Color(0xFFEC5F5F).copy(alpha = 0.8f),
            Color(0xFFDC3939),
            Color(0xFFEA1414)
        ),
        start = Offset(0f, 30f),
        end = Offset(400f, 0f)
    )
}




