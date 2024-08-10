package com.example.amansingh.presentation






import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CurrencyRupee
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.ManageAccounts
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.Whatsapp
import androidx.compose.material.icons.sharp.Apartment
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import coil.compose.AsyncImage
import com.example.amansingh.R
import com.example.amansingh.data.api.model.Results


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailsScreen(detailScreenViewModel: DetailScreenViewModel) {


    //var job by detailScreenViewModel.job
    val job = detailScreenViewModel.job.value


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, end = 10.dp, top = 80.dp, bottom = 120.dp)
    ) {
        item {
            // Title
            Text(
                text = job?.title ?: "Job Title",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth()
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
            ) {
                Icon(
                    imageVector = Icons.Sharp.Apartment,
                    contentDescription = "Company Name"
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = job?.company_name ?: "Company Name",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }


            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Gray)
            ) {
                AsyncImage(
                    model = job?.creatives?.get(0)?.thumb_url ?: "",
                    contentDescription = "Job image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.height(16.dp))


            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Icon(
                        imageVector = Icons.Filled.LocationOn,
                        contentDescription = "Job Location",
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "${job?.primary_details?.Place ?: "Job Details"}",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }

                Row {
                    Icon(
                        imageVector = Icons.Filled.CurrencyRupee,
                        contentDescription = "Salary Range",
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "${job?.primary_details?.Salary ?: "Salary Range"}",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Icon(
                        imageVector = Icons.Filled.ManageAccounts,
                        contentDescription = "Job Type",
                        modifier = Modifier.size(20.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "${job?.primary_details?.Job_Type ?: "Job Type"}",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }

                Row {
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Experience: ${job?.primary_details?.Experience ?: "Experience"}",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }
            }

            Row {
                Icon(
                    imageVector = Icons.Filled.Phone,
                    contentDescription = "Job Type",
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "${job?.custom_link}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )

            }

            Spacer(modifier = Modifier.height(16.dp))

            WhatsAppCard(job)

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "More Information", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            //other details
            Row{
                Text(
                    text = "Experience: ${job?.other_details ?: "Job Description"}",
                    fontSize = 14.sp,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))


            // Footer: FB Shares and Views
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Row {
                    Icon(
                        imageVector = Icons.Filled.Facebook,
                        contentDescription = "FaceBook View",
                        modifier = Modifier.size(20.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "${job?.fb_shares ?: 0}",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Light
                    )
                }

                Row {
                    Icon(
                        imageVector = Icons.Filled.RemoveRedEye,
                        contentDescription = "Views",
                        modifier = Modifier.size(20.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "${job?.views ?: 0}",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Light
                    )
                }
            }
        }

    }
}


@Composable
fun WhatsAppCard(job: Results?) {
    val context = LocalContext.current
    val whatsappLink = job?.contact_preference?.whatsapp_link

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clickable {
                whatsappLink?.let { openLinkInBrowser(context, it) }
            },
        colors = CardDefaults.cardColors(containerColor = Color(0xFF075E54))
    ) {
        Row(
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Whatsapp us between " +
                        "${job?.contact_preference?.preferred_call_start_time?: "Whatsapp Time"}" +
                        " to ${job?.contact_preference?.preferred_call_end_time?: "Whatsapp Time"}",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }
    }
}

fun openLinkInBrowser(context: Context, link: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
    ContextCompat.startActivity(context, intent, null)
}