import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: 'auth',
    loadChildren: () =>
      import('./auth/authentication.routes').then(
        (m) => m.Authentication_Routes
      ),
  },
];
