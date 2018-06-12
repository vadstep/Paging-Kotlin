/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.codelabs.paging.di

import com.example.android.codelabs.paging.api.GithubService
import com.example.android.codelabs.paging.data.GithubRepository
import com.example.android.codelabs.paging.db.GithubLocalCache
import com.example.android.codelabs.paging.db.RepoDatabase
import com.example.android.codelabs.paging.ui.SearchRepositoriesViewModel
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext
import java.util.concurrent.Executor
import java.util.concurrent.Executors

    val appModule = applicationContext {
        viewModel { SearchRepositoriesViewModel(get()) }
        bean { GithubRepository(get(),get())}
        bean { GithubService.create()}
        bean { GithubLocalCache(get(),get()) }
        bean { RepoDatabase.getInstance(get()).reposDao()}
        bean {Executors.newSingleThreadExecutor() as Executor }
    }

