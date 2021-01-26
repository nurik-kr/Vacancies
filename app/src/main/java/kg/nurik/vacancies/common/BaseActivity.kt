package kg.nurik.vacancies.common

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import kg.nurik.vacancies.R

abstract class BaseActivity : AppCompatActivity() {

    protected fun createDrawer(toolbar: Toolbar) {
        val header = createAccountHeader()
        val search = PrimaryDrawerItem().withName(getString(R.string.search_ru))
            .withIdentifier(1)
            .withIcon(R.drawable.ic_search)
        val vacancies = PrimaryDrawerItem().withName(getString(R.string.favorite_vacancies))
            .withIdentifier(2)
            .withIcon(R.drawable.icon_favorite_drawable)
        val exit = PrimaryDrawerItem().withName(getString(R.string.exit))
            .withIdentifier(3)
            .withIcon(R.drawable.icon_exit)

        DrawerBuilder()
            .withActivity(this)
            .withToolbar(toolbar)
            .withSelectedItem(-1) //на старте ничего не будет выбранно
            .withOnDrawerNavigationListener {
                onBackPressed()
                return@withOnDrawerNavigationListener true
            }
            .withAccountHeader(header)
            .addDrawerItems(
                search,
                vacancies,
                DividerDrawerItem(),
                exit
            ) //DividerDrawerItem() черточка
            .build()
    }

    private fun createAccountHeader(): AccountHeader {
        return AccountHeaderBuilder()
            .withActivity(this)
            .addProfiles(
                ProfileDrawerItem()
                    .withName(R.string.name_header)
                    .withIcon(R.drawable.logo)
                    .withEmail("0.1")
            )
            .withHeaderBackground(R.drawable.background_drawer)
            .withAlternativeProfileHeaderSwitching(false) //переключение между аккаунтами
            .withTranslucentStatusBar(true)
            .withAlternativeProfileHeaderSwitching(false)
            .build()
    }
}