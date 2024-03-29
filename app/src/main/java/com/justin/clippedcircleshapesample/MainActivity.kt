package com.justin.clippedcircleshapesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.justin.clippedcircleshape.ClipDirection
import com.justin.clippedcircleshape.ClippedCircleShape
import com.justin.clippedcircleshapesample.ui.theme.ClippedCircleShapeSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClippedCircleShapeSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(24.dp)
                    ) {

                        item {
                            RowItem(title = "Circle shape image view") {
                                Image(
                                    painter = painterResource(id = R.drawable.a),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(60.dp)
                                        .clip(CircleShape)
                                )
                            }
                        }

                        item {
                            RowItem(title = "Clipped Circle shape image view : ClipDirection.START") {
                                Image(
                                    painter = painterResource(id = R.drawable.b),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(60.dp)
                                        .clip(ClippedCircleShape(clipDirection = ClipDirection.START))
                                )
                            }
                        }

                        item {
                            RowItem(title = "Clipped Circle shape image view : ClipDirection.TOP") {
                                Image(
                                    painter = painterResource(id = R.drawable.c),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(60.dp)
                                        .clip(ClippedCircleShape(clipDirection = ClipDirection.TOP))
                                )
                            }
                        }

                        item {
                            RowItem(title = "Clipped Circle shape image view : ClipDirection.END") {
                                Image(
                                    painter = painterResource(id = R.drawable.e),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(60.dp)
                                        .clip(ClippedCircleShape(clipDirection = ClipDirection.END))
                                )
                            }
                        }

                        item {
                            RowItem(title = "Clipped Circle shape image view : ClipDirection.BOTTOM") {
                                Image(
                                    painter = painterResource(id = R.drawable.f),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(60.dp)
                                        .clip(ClippedCircleShape(clipDirection = ClipDirection.BOTTOM))
                                )
                            }
                        }

                        item {
                            Spacer(modifier = Modifier.height(32.dp))
                        }

                        val userItems: List<Int> = listOf(
                            R.drawable.a,
                            R.drawable.b,
                            R.drawable.c,
                            R.drawable.e,
                            R.drawable.f
                        )

                        item {
                            RowItem(title = "Clipped Circle in a list") {
                                LazyRow(modifier = Modifier.fillMaxWidth()) {
                                    itemsIndexed(items = userItems) { index: Int, item: Int ->
                                        Image(
                                            painter = painterResource(id = item),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(60.dp)
                                                .clip(
                                                    if (index == 0) {
                                                        CircleShape
                                                    } else {
                                                        ClippedCircleShape(clipDirection = ClipDirection.START)
                                                    }
                                                )
                                        )
                                    }
                                }
                            }
                        }

                        item {
                            Spacer(modifier = Modifier.height(32.dp))
                        }

                        item {
                            RowItem(title = "Clipped Circle in a list") {
                                LazyRow(modifier = Modifier.fillMaxWidth()) {
                                    itemsIndexed(items = userItems) { index: Int, item: Int ->
                                        Image(
                                            painter = painterResource(id = item),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(60.dp)
                                                .clip(
                                                    if (index == (userItems.size - 1)) {
                                                        CircleShape
                                                    } else {
                                                        ClippedCircleShape(clipDirection = ClipDirection.END)
                                                    }
                                                )
                                        )
                                    }
                                }
                            }
                        }

                        item {
                            Spacer(modifier = Modifier.height(32.dp))
                        }

                        item {
                            ItemsWithMoreNumberOfItems()
                        }

                        item {
                            Spacer(modifier = Modifier.height(32.dp))
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun RowItem(title: String, content: @Composable () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = title,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(8.dp))
        content()
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun ItemsWithMoreNumberOfItems() {
    RowItem(title = "Clipped Circle in a list") {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.a),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clip(ClippedCircleShape(clipDirection = ClipDirection.END))
            )

            Image(
                painter = painterResource(id = R.drawable.b),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clip(ClippedCircleShape(clipDirection = ClipDirection.END))
            )

            Image(
                painter = painterResource(id = R.drawable.c),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clip(ClippedCircleShape(clipDirection = ClipDirection.END))
            )

            Image(
                painter = painterResource(id = R.drawable.d),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clip(ClippedCircleShape(clipDirection = ClipDirection.END))
            )

            Box(
                modifier = Modifier
                    .size(60.dp)
                    .background(
                        color = Color.Gray,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "+5", color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                )
            }
        }
    }
}