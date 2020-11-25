package com.utsman.data.model.dto

import com.utsman.data.model.AppsItem
import com.utsman.data.model.Aptoide
import com.utsman.data.model.Category

fun Aptoide.toCategoryBannerView(category: Category?): CategorySealedView.CategoryBannerView? {
    val list = datalist?.list?.map { app ->
        AppsSealedView.AppsView.simple {
            id = app.id ?: 0
            name = app.name ?: ""
            size = app.size ?: 0
            icon = app.icon ?: ""
        }
    } ?: emptyList()

    return CategorySealedView.CategoryBannerView.simple {
        name = category?.name ?: ""
        query = category?.query
        apps = list
        image = category?.image ?: ""
        desc = category?.desc ?: ""
    }
}

fun Aptoide.toCategoryView(category: Category?): CategorySealedView.CategoryView? {
    val list = datalist?.list?.map { app ->
        AppsSealedView.AppsView.simple {
            id = app.id ?: 0
            name = app.name ?: ""
            size = app.size ?: 0
            icon = app.icon ?: ""
        }
    } ?: emptyList()

    return CategorySealedView.CategoryView.simple {
        name = category?.name ?: ""
        query = category?.query
        apps = list
    }
}

fun AppsItem.toAppsBannerView(): AppsSealedView.AppsBannerView {
    return AppsSealedView.AppsBannerView.simple {
        id = this@toAppsBannerView.id ?: 0
        name = this@toAppsBannerView.name ?: ""
        downloads = this@toAppsBannerView.stats?.downloads ?: 0
        size = this@toAppsBannerView.size ?: 0
        icon = this@toAppsBannerView.icon ?: ""
        image = this@toAppsBannerView.graphic ?: ""
    }
}

fun AppsItem.toAppsView(): AppsSealedView.AppsView {
    return AppsSealedView.AppsView.simple {
        id = this@toAppsView.id ?: 0
        name = this@toAppsView.name ?: ""
        size = this@toAppsView.size ?: 0
        icon = this@toAppsView.icon ?: ""
    }
}