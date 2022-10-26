import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ContactService } from 'src/app/contact.service';
import { ToastrService } from 'ngx-toastr';
import { timeout } from 'rxjs';
import { NotificationService } from 'src/app/notification.service';
@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css'],
})
export class SearchComponent implements OnInit {
  formsearch: FormGroup;
  contact: any;
  successrequest = false;
  constructor(
    private formBuilder: FormBuilder,
    private contactService: ContactService,
    private toastr: NotificationService
  ) {}

  ngOnInit(): void {
    this.formsearch = this.formBuilder.group({
      id: '',
    });
  }

  onSubmit() {
    if (this.formsearch.get('id') != null) {
      this.contactService
        .getContact(this.formsearch.get('id')!.value)
        .subscribe((data) => {
          console.log(data);
          this.successrequest = true;
          this.contact = data;
          if (data != null) {
            this.toastr.showSuccess('Contact trouvé', 'Reherche');
          }
        });
    }
  }
}
