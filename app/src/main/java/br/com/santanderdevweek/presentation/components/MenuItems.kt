package br.com.santanderdevweek.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.santanderdevweek.domain.mock.mockFeature
import br.com.santanderdevweek.domain.mock.mockSantander
import br.com.santanderdevweek.domain.models.Feature
import br.com.santanderdevweek.presentation.theme.SantanderDevWeekTheme
import br.com.santanderdevweek.presentation.theme.Spacing_1
import br.com.santanderdevweek.presentation.theme.Spacing_2


@Composable
fun MenuItems(
    modifier: Modifier = Modifier,
    features: List<Feature> = emptyList()
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(Spacing_2)
    ) {
        items(features) { feature ->
            AppCard(
                modifier = Modifier
                    .size(
                        width = 110.dp,
                        height = 96.dp
                    ),
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    SvgImage(
                        url = feature.icon
                    )
                    Text(
                        text = feature.description,
                        modifier = Modifier.padding(top = Spacing_1)
                    )
                }

            }
        }
    }
}

@Preview
@Composable
fun MenuItemsPreview() {
    SantanderDevWeekTheme {
        MenuItems(features = mockSantander.features)
    }
}